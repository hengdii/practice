package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 比较含退格的字符串
 * @author: Jiaty
 * @create: 2020-10-19 10:16
 **/

public class Solution844 {

    public static boolean backspaceCompare(String S, String T) {
        return getStr(S).equals(getStr(T));
    }

    public static String getStr(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '#') {
                continue;
            }
            if (str.charAt(i) == '#') {
                if (result.length() != 0) {
                    result.deleteCharAt(result.length() - 1);
                }
                continue;
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";


        String S = "gtc#uz#";
        String T = "gtcm##uz#";
//        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare1(S, T));
    }

    public static boolean backspaceCompare1(String S, String T) {
        int pointA = S.length() - 1;
        int pointB = T.length() - 1;
        while (pointA > -1 && pointB > -1) {
            int timesA = 0;
            int timesB = 0;
            while (S.charAt(pointA)=='#'){
                timesA++;
                pointA--;
            }
            while (T.charAt(pointB)=='#'){
                timesB++;
                pointB--;
            }
            if (S.charAt(pointA - timesA) != T.charAt(pointB -timesB)){
                return false;
            }
            pointA--;
            pointB--;
        }
        return true;
    }


}