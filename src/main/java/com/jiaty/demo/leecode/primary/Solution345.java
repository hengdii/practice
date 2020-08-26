package com.jiaty.demo.leecode.primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: practice
 * @description: 反转元音字母
 * @author: Jiaty
 * @create: 2020-08-26 15:12
 **/

public class Solution345 {

    public static String reverseVowels(String s) {
        List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (characterList.contains(chars[start]) && characterList.contains(chars[end])) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            } else if (!characterList.contains(chars[start])) {
                start++;
            } else {
                end--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            result.append(chars[i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseVowels("Ui"));
    }
}