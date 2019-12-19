package com.jiaty.demo.date20190729;

/**
 * @program: Practice
 * @description: synchronized关键字
 * @author: jiaty
 * @create: 2019-07-29 14:07
 **/

public class test1 {

    public static synchronized void  demo1(){
        System.out.println("静态方法");
    }

    public  void demo2(){
        System.out.println("普通方法");
    }

}