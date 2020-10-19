package com.jiaty.demo.thread;

/**
 * @program: practice
 * @description: 线程局部变量
 * @author: Jiaty
 * @create: 2020-10-16 15:10
 **/

public class ThreadLocalDemo {

    private static String str;

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * ThreadLocal 用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
     * 也就是说 ThreadLocal 可以为每个线程创建一个【单独的变量副本】，相当于线程的 private static 类型变量。
     *
     * ThreadLocal 的作用和同步机制有些相反：
     *          同步机制是为了保证多线程环境下数据的一致性；而 ThreadLocal 是保证了多线程环境下数据的独立性。
     *
     * */
    public static void main(String[] args) {
        str = "main";
        threadLocal.set("main");


        Thread thread = new Thread() {
            @Override
            public void run() {
                str = "thread";
                System.out.println(threadLocal.get());
                threadLocal.set("thread");
            }
        };

        thread.start();


        try {
            //保证线程执行完
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(str);
        System.out.println(threadLocal.get());

    }


}