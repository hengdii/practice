package com.jiaty.demo.date20190801;

/**
 * @program: Practice
 * @description:
 * @author: jiaty
 * @create: 2019-08-01 21:51
 **/

public class TestB extends TestA {

    static void B() {
        System.out.println("a");
    }

    public TestB() {
        System.out.println("b");
    }


    public static void main(String[] args) {
        TestA a = new TestB();
        a = new TestB();

    }

}