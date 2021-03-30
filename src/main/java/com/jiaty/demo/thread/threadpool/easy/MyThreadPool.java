package com.jiaty.demo.thread.threadpool.easy;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: practice
 * @description: 简易线程池
 * @author: Jiaty
 * @create: 2021-03-31 00:13
 **/

public class MyThreadPool {

    /**
     * 存放线程的集合
     */
    private ArrayList<MyThread> threads;

    /**
     * 任务队列
     */
    private ArrayBlockingQueue<Runnable> taskQueue;

    private int threadNum;

    private int workThreadNum;

    private final ReentrantLock mainLock = new ReentrantLock();

    public MyThreadPool(int initThreadNum) {
        threadNum = initThreadNum;
        threads = new ArrayList<>(initThreadNum);

        taskQueue = new ArrayBlockingQueue<>(initThreadNum * 4);
        workThreadNum = 0;
    }


    public void execute(Runnable runnable) {
        mainLock.lock();
        try {
            if (workThreadNum < threadNum) {
                MyThread myThread = new MyThread(runnable);
                myThread.start();
                threads.add(myThread);
                workThreadNum++;
            } else {
                if (!taskQueue.offer(runnable)) {
                    rejectTask();
                }
            }
        } finally {
            mainLock.unlock();
        }
    }

    private void rejectTask() {
        System.out.println("任务队列已满，无法继续添加，请扩大您的初始化线程池！");
    }


    class MyThread extends Thread {
        private Runnable task;
        /**
         * 表示是否该运行此线程
         */
        private volatile boolean running = true;

        public MyThread(Runnable runnable) {
            this.task = runnable;
        }

        @Override
        public void run() {
            while (running) {
                if (task != null) {
                    task.run();
                    task = null;
                } else {
                    Runnable queueTask = taskQueue.poll();
                    if (queueTask != null) {
                        queueTask.run();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(5);
        Runnable task = () -> System.out.println("当前执行线程" + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            myThreadPool.execute(task);
        }
    }

}