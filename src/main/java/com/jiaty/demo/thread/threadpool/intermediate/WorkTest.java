package com.jiaty.demo.thread.threadpool.intermediate;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2021-03-31 00:56
 **/

public class WorkTest {

    public static void main(String[] args) {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            if (i == 30) {
                defaultThreadPool.addWorkers(10);
            }
            Job job = new Job();
            defaultThreadPool.execute(job);
        }


    }
}