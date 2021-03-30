package com.jiaty.demo.thread.threadpool.intermediate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: practice
 * @description: 线程池
 * @author: Jiaty
 * @create: 2021-03-31 00:40
 **/

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    /**
     * 线程池维护工作者线程的最大数量
     */
    private static final int MAX_WORKER_NUMBERS = 30;

    /**
     * 线程池维护工作者线程的最默认工作数量
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;

    /**
     * 线程池维护工作者线程的最小数量
     */
    private static final int MIN_WORKER_NUMBERS = 1;

    /**
     * 维护一个工作列表,里面加入客户端发起的工作
     */
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    /**
     * 工作者线程的列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    /**
     * 工作者线程的数量
     */
    private int workerNum;
    /**
     * 每个工作者线程编号生成
     */
    private AtomicLong threadNum = new AtomicLong();

    DefaultThreadPool(int num) {
        if (num > MAX_WORKER_NUMBERS) {
            this.workerNum = MAX_WORKER_NUMBERS;
        } else {
            this.workerNum = num;
        }

    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker);
            thread.start();
        }
    }


    /**
     * 执行一个任务（Job），Job必须实现Runnable
     *
     * @param job
     */
    @Override
    public void execute(Job job) {
        if (job == null) {
            throw new NullPointerException();
        }
        synchronized (jobs) {
            jobs.addLast(job);
            jobs.notify();
        }
    }

    /**
     * 关闭线程池
     */
    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    /**
     * 增加工作者线程，即用来执行任务的线程
     *
     * @param num
     */
    @Override
    public void addWorkers(int num) {
        //加锁，防止该线程还没增加完而下个线程继续增加导致工作者线程超过最大值
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    /**
     * 减少工作者线程
     *
     * @param num
     */
    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num > this.workerNum) {
                throw new IllegalArgumentException("超过了已有的线程数量");
            }
            for (int i = 0; i < num; i++) {
                Worker worker = workers.get(i);
                if (worker != null) {
                    worker.shutdown();
                    workers.remove(i);
                }
            }
            this.workerNum -= num;
        }
    }

    /**
     * 获取正在等待执行的任务数量
     *
     * @return
     */
    @Override
    public int getJobSize() {
        return workers.size();
    }

    class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            jobs.wait();  // 线程等待唤醒
                        } catch (InterruptedException e) {
                            //感知到外部对该线程的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    job.run();
                }
            }
        }

        /**
         * 终止该线程
         */
        public void shutdown() {
            running = false;
        }
    }
}