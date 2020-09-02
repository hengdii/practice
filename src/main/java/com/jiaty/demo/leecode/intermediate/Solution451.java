package com.jiaty.demo.leecode.intermediate;

import java.util.*;

/**
 * @program: practice
 * @description: 根据字符出现频率排序
 * @author: Jiaty
 * @create: 2020-09-01 15:44
 **/

public class Solution451 {


    /**
     * 1.创建一个map来存每个char及其次数
     * 2.创建一个list数组，key是数组下标（次数），value是相同次数的字符（char）
     * 3.然后从最长的s.length()开始递减遍历，因为题目要求的是要最长的排在前面。s.length()肯定比所有的字符长度都大。
     * 4.逐个拼接
     */


    public static String frequencySort(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : s.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            int f = map.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i > -1; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("aaaaatree"));
    }

    /**
     * 1.用数组 存储字符串的次数和字符  同时利用了ASCII码值
     *
     * @param s
     * @return
     */
    public String frequencySort1(String s) {
        HashMap<Integer, String> map = new HashMap<>();

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                } else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();
    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }

}