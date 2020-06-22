package com.jiaty.demo.test.tryCatchTest;

/**
 * @program: Practice
 * @description: 异常测试
 * @author: Jiaty
 * @create: 2020-06-22 10:51
 **/

public class ExceptionTest {


    public static void main(String[] args) {

        try {
            throw new RuntimeException("123213");
        }catch (RuntimeException re){
            System.out.println("RuntimeException");
        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            System.out.println("12312");
        }



    }
}