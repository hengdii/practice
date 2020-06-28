package com.jiaty.demo.test.numberTest;

/**
 * @program: Practice
 * @description: long的默认值
 * @author: Jiaty
 * @create: 2020-06-22 17:52
 **/

public class LongTest {


    public static void main(String[] args) {
        Long itemId;
        int i = 3;
        if (i == 1) {
            itemId = Long.parseLong("2");
        } else {
            itemId = Long.parseLong("1");
        }
        System.out.println(itemId);
    }
}