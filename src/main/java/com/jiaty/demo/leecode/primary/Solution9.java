package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 回文数
 * @author: Jiaty
 * @create: 2020-07-23 13:51
 **/

public class Solution9 {
    /**
     * 直接使用String的反转
     * 用时：12ms
     * 内存：39.6m
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome1(23242232));
    }

    /**
     * 第二个解法，比较容易理解，就是第一个和最后一个字符去比较
     * 用时：10ms
     * 内存：39.2m
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        for (int i = 0; i <= length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }


}