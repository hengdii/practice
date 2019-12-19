package com.jiaty.demo.date20191210;

/**
 * @program: Practice
 * @description: while用法的测试
 * @author: jiaty
 * @create: 2019-12-10 15:33
 **/

public class WhileTest {

    private static Boolean convert(Boolean flg){

        return true;
    }



    public static void main(String[] args) throws InterruptedException {
        int i= 1;
        Boolean flg = true;

        while(flg){
            flg = convert(flg);
            System.out.println(i++);
            Thread.sleep(200000);
        }



    }
}