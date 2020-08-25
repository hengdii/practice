package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 重复的子字符串
 * @author: Jiaty
 * @create: 2020-08-24 10:35
 **/

public class Solution459 {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abab"
     * <p>
     * 输出: True
     * <p>
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:
     * <p>
     * 输入: "aba"
     * <p>
     * 输出: False
     * 示例 3:
     * <p>
     * 输入: "abcabcabcabc"
     * <p>
     * 输出: True
     * <p>
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     */

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return false;
        }
        for (int i = 0, j = 1; j < s.length(); j++) {
            int divde = s.length() / j;
            if (j * divde == s.length()) {
                String begin = s.substring(i, j);
                if (repeate(begin, s.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeate(String a, String s) {
        if (s.length() == 0) {
            return true;
        }
        int length = a.length();
        if (s.length() < length) {
            return false;
        }
        String substring = s.substring(0, length);
        if (!a.equals(substring)) {
            return false;
        }
        return repeate(a, s.substring(length));
    }


    public static void main(String[] args) {
        String s = "abcabcabcabcd";
//        System.out.println(repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern1(s));
    }


    /**
     * 官方解法
     *
     * 从位置 1 开始查询，并希望查询结果不为位置 n，这与移除字符串的第一个和最后一个字符是等价的
     */

    public static boolean repeatedSubstringPattern1(String s) {
        int index = (s + s).indexOf(s, 1);
        return index != s.length();
    }

}