package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 最后一个单词的长度
 * @author: Jiaty
 * @create: 2020-08-06 16:38
 **/

public class Solution58 {

    public static int lengthOfLastWord(String s) {
        if (s.length() != 0) {
            int i = s.length() - 1;
            while (i > 0 && s.charAt(i) == ' ') {
                i = i - 1;
            }
            s = s.substring(0, i+1);
        }else {
            return 0;
        }
        for (int j = s.length() - 1; j > -1; j--) {
            if (s.charAt(j) == ' ') {
                return s.length() - 1 - j;
            }
        }
        return s.length();
    }


    public static void main(String[] args) {
        String s = "  ";

        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord1(s));
        System.out.println(lengthOfLastWord2(s));
    }


    /**
     * 更优雅解法
     */
    public static int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if(end < 0) {
            return 0;
        }
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }



    public static int lengthOfLastWord2(String s){
        int i = s.length() -1;
        while (i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        if (i < 0){
            return 0;
        }
        for (int j = i; j > -1; j--) {
            if (s.charAt(j) == ' ') {
                return i - j;
            }
        }
        return i +1;
    }
}