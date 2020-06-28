package com.jiaty.demo.test.stringTest;

import com.alibaba.fastjson.JSON;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-06-24 00:57
 **/

public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JSON.toJSONBytes("错误悉尼"));
        System.out.println(stringBuilder.toString());


    }
}