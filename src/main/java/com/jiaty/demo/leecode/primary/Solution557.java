package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 反转字符串中的单词 3
 * @author: Jiaty
 * @create: 2020-08-30 22:13
 **/

public class Solution557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || " ".equals(s)) {
            return s;
        }
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(new StringBuilder(string).reverse().append(" "));
        }
        return stringBuilder.toString().substring(0, s.length());
    }

//    private String rever(String s) {
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//    }


    public static void main(String[] args) {


    }
}