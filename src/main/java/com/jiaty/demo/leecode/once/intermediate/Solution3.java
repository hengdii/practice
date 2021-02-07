package com.jiaty.demo.leecode.once.intermediate;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: 不含有重复字符的 最长子串
 * @author: jiaty
 * @create: 2020-01-06 11:57
 **/
@Slf4j
public class Solution3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。(字符中不含有重复的字符)
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        long startTime = System.currentTimeMillis();
        char[] str = s.toCharArray();
        int[] exist = new int[127];
        int i1 = 0;
        int result = 0;
        int i2 = 0;
        for (; i2 < str.length; ++i2) {
            if (exist[str[i2]] >= i1 + 1) {
                result = Math.max(i2 - i1, result);
                i1 = exist[str[i2]];
            }
            exist[str[i2]] = i2 + 1;
        }
        System.out.println(System.currentTimeMillis() - startTime + "" + "--------------1");
        return Math.max(i2 - i1, result);
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
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
//
        System.out.println(lengthOfLongestSubStringTest2(s));

        System.out.println(lengthOfLongestSubStringTest3(s));
    }

    public static int lengthOfLongestSubStringTest2(String s) {
        long startTime = System.currentTimeMillis();
        int length = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(length * length);
        for (; end < length; end++) {
            char c = s.charAt(end);
            if (map.get(c) != null) {
                start = Math.max(map.get(c) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(c, end);
        }
        System.out.println(System.currentTimeMillis() - startTime + "" + "--------------2");
        return max;
    }


    private static int lengthOfLongestSubStringTest3(String s) {
        long startTime = System.currentTimeMillis();
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (; end < s.length(); end++) {
            char a = s.charAt(end);
            if (map.get(a) != null) {
                //start的滑动
                start = Math.max(map.get(a) + 1, start);
            }
            max = Math.max(max, end - start+1);
            map.put(a, end);
        }
        return max;
    }

}