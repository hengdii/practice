package com.jiaty.demo.leecode.primary;

import java.util.*;

/**
 * @program: practice
 * @description: 查找常用字符
 * @author: Jiaty
 * @create: 2020-10-14 10:16
 **/

public class Solution1002 {

    public static List<String> commonChars(String[] A) {
        List<String> stringList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (String s : A) {
            for (Character c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        map.forEach((k, v) -> {
            if (v == A.length) {
                stringList.add(k.toString());
            }
        });
        return stringList;
    }


    public static List<String> commonChars1(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : str.toCharArray()) {
                if (map.get(c) == null) {
                    continue;
                }
                map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
            }
            map = map2;
        }
        List<String> ans = new ArrayList<>();
        for (Character c : map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                ans.add(String.valueOf(c));
            }
        }
        return ans;


    }


    public static void main(String[] args) {
        String [] a = new String[]{"bella","label","roller"};
//        commonChars1(a).forEach(System.out::print);
        System.out.println("-----------------------");
        commonChars2(a).forEach(System.out::print);
    }


    public static List<String> commonChars2(String[] A){
        int[] minfreq = new int[26];
        Arrays.fill(minfreq,Integer.MAX_VALUE);
        for (String word : A){
            int [] freq = new int[26];
            int length = word.length();
            for (int i = 0;i < length; ++i){
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0;i < 26;++i){
                minfreq[i] = Math.min(minfreq[i],freq[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0;i < 26;++i){
            for (int j = 0; j < minfreq[i]; ++j){
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }
        return ans;
    }
}