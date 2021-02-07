package com.jiaty.demo.leecode.once.intermediate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: practice
 * @description: 划分字母区间
 * @author: Jiaty
 * @create: 2020-09-14 10:27
 **/

public class Solution763 {
    /**
     * Wrong  控制不好指针
     *
     * @param s
     * @return
     */

    public static List<Integer> partitionLabels(String s) {

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int startIndex = 0;
        while (startIndex <= s.length()) {
            Integer integer = splitString(s, startIndex, map);
            list.add(integer);
            startIndex += integer + 1;
        }
        return list;
    }


    public static Integer splitString(String s, int startIndex, Map<Character, Integer> map) {
        int endIndex = 0;
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = map.get(c);
            endIndex = Math.max(endIndex, index);
//            if (i == endIndex) {
//                break;
//            }
        }
        return endIndex - startIndex + 1;
    }


    /**
     * 官方解法
     */
    public static List<Integer> partitionLabels1(String S) {
        // 做映射表，记录每个字母最后出现的位置
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        System.out.println(s.lastIndexOf('a'));
        List<Integer> list = partitionLabels3(s);
//        List<Integer> list = partitionLabels1(s);
        for (Integer i : list) {
            System.out.println(i);
        }

    }

    /**
     * 容易理解一点
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels2(String s) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[char2Index(s.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < s.length() && i <= lastIndex; i++) {
                int index = lastIndexOfChar[char2Index(s.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }


    private static int char2Index(char c) {
        return c - 'a';
    }


    /**
     * 费劲的递归
     */
    public static List<Integer> partitionLabels3(String S) {
        List<Integer> integers = new ArrayList<>();
        if (S == null) {
            return integers;
        }
        getPartition(S, integers);
        return integers;
    }


    public static void getPartition(String s, List<Integer> integers) {
        if (s == null || s.length() == 0) {
            return;
        }
        int index = s.lastIndexOf(s.charAt(0));
        for (int i = 1; i <= index; i++) {
            index = Math.max(index, s.lastIndexOf(s.charAt(i)));
        }
        integers.add(index + 1);
        getPartition(s.substring(index + 1), integers);


    }

}