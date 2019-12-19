package com.jiaty.demo.test.date20190729;

/**
 * @program: Practice
 * @description: 测试类
 * @author: jiaty
 * @create: 2019-07-29 15:11
 **/

public class test2 {


    public static void main(String[] args) {
        test1 t1 = new test1();

        Thread thread1 = new Thread() {
            public void run() {
                test1.demo1();
                t1.demo2();
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                test1.demo1();
                t1.demo2();
            }
        };
        thread1.start();
        thread2.start();

    }

}