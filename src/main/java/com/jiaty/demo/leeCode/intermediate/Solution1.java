package com.jiaty.demo.leeCode.intermediate;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: practice
 * @description: 不含有重复字符的 最长子串
 * @author: jiaty
 * @create: 2020-01-06 11:57
 **/

public class Solution1 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。(字符中不含有重复的字符)
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] exist = new int[127];
        int i1 = 0;
        int result = 0;
        int i2 = 0;
        for (; i2 < str.length; ++i2) {
            if (exist[str[i2]] >= i1 + 1) {
                result = i2 - i1 > result ? i2 - i1 : result;
                i1 = exist[str[i2]];
            }
            exist[str[i2]] = i2 + 1;
        }
        return i2 - i1 > result ? i2 - i1 : result;
    }

//    public static int lengthOfLongestSubstring1(String s){
//        char [] str = s.toCharArray();
//        System.out.println(str
//        int i = 0;
//        int j = 0;
//        for (;;){
//
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(Solution1.lengthOfLongestSubstring("bbbbbdasdhasudadfsdfsfeqw"));
    }


}