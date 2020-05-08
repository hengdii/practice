package com.jiaty.demo.test.interviewTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Practice
 * @description: 面试的一些测试
 * @author: jiaty
 * @create: 2020-01-09 00:25
 **/

public class interviewTest {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
//        count++;
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println();
        CountDownLatch countDownLatch = new CountDownLatch(20);
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                    countDownLatch.countDown();
                }
            });
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    //第一种，在方法上加synchronized
    //第二种，将count++变成原子的
}