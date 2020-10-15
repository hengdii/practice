package com.jiaty.demo.thread;

import java.util.concurrent.*;

/**
 * @program: practice
 * @description: 多线程的实现方式
 * @author: Jiaty
 * @create: 2020-10-14 15:23
 **/

public class ThreadDemo {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {

            System.out.println("This is Thread");
        }
    }

    private static class MyThread2 implements Runnable {

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
            System.out.println("This is Runable");
        }
    }

    private static class MyThread3 implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            return String.valueOf(System.currentTimeMillis());
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread
        Thread thread1 = new MyThread1();
        thread1.start();

        //实现Runable
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();

        //实现Callable
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyThread3 call = new MyThread3();
        Future<String> future = executorService.submit(call);
        String time = future.get();
        System.out.println(time);

        //线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        Future<String> stringFuture = executorService1.submit(() -> "newFixedThreadPool");
        System.out.println(stringFuture.get());

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> System.out.println("newSingleThreadExecutor"));

        //false
        System.out.println(thread1.isAlive());
        //false
        System.out.println(thread2.isAlive());
        //false
        System.out.println(executorService.isShutdown());
        //false
        System.out.println(executorService.isTerminated());
        //false
        System.out.println(service.isShutdown());
        //false
        System.out.println(service.isTerminated());


    }


}