package com.jiaty.demo.test.stringTest;

/**
 * @program: Practice
 * @description:
 * @author: jiaty
 * @create: 2019-11-25 18:16
 **/

public class StringLengthTest {

    public static void main(String[] args) {

        String pro = "1568189946524153";

        boolean a = true;

        if (pro.length() <= 16) {
            a = false;
        }

        System.out.println(a);
    }
}