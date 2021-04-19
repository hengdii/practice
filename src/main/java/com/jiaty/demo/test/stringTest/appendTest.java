package com.jiaty.demo.test.stringTest;

/**
 * @program: practice
 * @description: 不可变String
 * @author: Jiaty
 * @create: 2021-04-11 11:24
 **/

public class appendTest {

    private static String appendStr(String s){
        s+="bbb";
        return s;
    }

    private static StringBuilder appendSb(StringBuilder stringBuilder){
        return stringBuilder.append("bbb");
    }



    public static void main(String[] args) {
        String s = "aaa";
        String ns = appendStr(s);
        System.out.println(s);


        StringBuilder stringBuilder = new StringBuilder("aaa");
        StringBuilder sb = appendSb(stringBuilder);
        System.out.println(stringBuilder.toString());

    }






}