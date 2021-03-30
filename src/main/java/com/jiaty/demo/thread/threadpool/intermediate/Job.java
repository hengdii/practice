package com.jiaty.demo.thread.threadpool.intermediate;

/**
 * @program: practice
 * @description: 任务
 * @author: Jiaty
 * @create: 2021-03-31 00:33
 **/

public class Job implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前执行线程"+Thread.currentThread().getName()+"Job 被执行了");
    }
}