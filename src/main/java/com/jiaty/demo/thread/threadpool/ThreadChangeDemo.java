package com.jiaty.demo.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: practice
 * @description: 动态更新线程池
 * @author: Jiaty
 * @create: 2021-04-22 01:37
 **/

public class ThreadChangeDemo {


    private static class NamedThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        private NamedThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + '-' + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    /**
     * 最初的线程池大小
     * @return
     */
    public static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new NamedThreadFactory("Jiaty"));
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        LinkedBlockingQueue queue = (LinkedBlockingQueue) executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                " 核心线程数：" + executor.getCorePoolSize() +
                " 活动线程数：" + executor.getActiveCount() +
                " 最大线程数：" + executor.getMaximumPoolSize() +
                " 线程池活跃度：" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " 任务完成数：" + executor.getCompletedTaskCount() +
                " 队列大小：" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数：" + queue.size() +
                " 队列剩余大小：" + queue.remainingCapacity() +
                " 队列使用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity()));
    }


    private static String divide(int a, int b) {
        return String.format("%1.2f%%", Double.parseDouble(a + "") / Double.parseDouble("" + b) * 100);
    }


    /**
     * 先提交任务给线程池，并修改线程池参数
     */
    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            executor.submit(()->{
                threadPoolStatus(executor,"创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor,"改变之前");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        threadPoolStatus(executor,"改变之后");
        Thread.currentThread().join();

    }

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

}