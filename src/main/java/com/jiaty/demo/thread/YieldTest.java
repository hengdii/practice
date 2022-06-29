package com.jiaty.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: practice
 * @description:
 * @author: tengyu5
 * @create: 2021/07/07 11:47
 **/

public class YieldTest {

    private Thread thread1,thread2,thread3;
    public static volatile AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
        while(Thread.activeCount() > 1){
            Thread.yield();
        }

    }


    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            while(i.get() < 10){
                System.out.println("t1="+i);
                i.incrementAndGet();
            }
        }
    }

    public static class Thread2 implements Runnable{

        @Override
        public void run() {
            while(i.get() < 10){
                System.out.println("t2="+i);
                i.incrementAndGet();
            }
        }
    }

    public static class Thread3 implements Runnable{

        @Override
        public void run() {
            while(i.get() < 10){
                System.out.println("t3="+i);
                i.incrementAndGet();
            }
        }
    }
}