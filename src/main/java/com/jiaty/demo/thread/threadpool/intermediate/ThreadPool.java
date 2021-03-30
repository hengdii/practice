package com.jiaty.demo.thread.threadpool.intermediate;

/**
 * @program: practice
 * @description: 线程池定义
 * @author: Jiaty
 * @create: 2021-03-31 00:34
 **/

public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行一个任务（Job），Job必须实现Runnable
     *
     * @param job
     */
    public void execute(Job job);

    /**
     * 关闭线程池
     */
    public void shutdown();

    /**
     * 增加工作者线程，即用来执行任务的线程
     *
     * @param num
     */
    public void addWorkers(int num);

    /**
     * 减少工作者线程
     *
     * @param num
     */
    public void removeWorker(int num);

    /**
     * 获取正在等待执行的任务数量
     *
     * @return
     */
    public int getJobSize();
}
