package com.jiaty.demo.leecode.once.primary;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: practice
 * @description: 最长回文串
 * @author: Jiaty
 * @create: 2021-03-16 18:01
 **/

public class Solution409 {

    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>(s.length());
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                break;
            }
            set.remove(c);
            count++;
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }


    public static void main(String[] args) {

    }


}