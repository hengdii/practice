package com.jiaty.demo.test.stringTest;

import java.util.Arrays;

/**
 * @program: Practice
 * @description: 字符串的截取
 * @author: jiaty
 * @create: 2019-05-28 14:50
 **/

public class SplitStr {
//    String str = "[{1231231}]";

    public static void main(String[] args) {

        String str = "[{23456789},{12312312},{1231231}]";
        String[] str1 = str.split(",");
//        System.out.println(str.substring(1,str.length()-1));
        System.out.println(Arrays.toString(str1));
    }

}