package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 验证回文字符串 Ⅱ
 * @author: Jiaty
 * @create: 2020-08-26 17:54
 **/

public class Solution680 {

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    char c3 = chars[i], c4 = chars[j];
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = start + 1, j = end; i < j; i++, j--) {
                    char c3 = chars[i], c4 = chars[j];
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
//        System.out.println(validPalindrome1(s));
        System.out.println(validPalindrome(s));

    }

    /**
     * 递归解法：超出了时间限制
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome1(String s) {
        return valid(s, false);
    }

    public static boolean valid(String s, boolean flg) {
        int len = s.length();
        if (len == 1 || len == 0) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return valid(s.substring(1, s.length() - 1), flg);
        } else if (flg) {
            return false;
        }
        flg = true;
        return valid(s.substring(1, len), flg) || valid(s.substring(0, len - 1), flg);
    }


    /**
     * 大佬的递归写法
     */

    public static boolean validPalindrome2(String s) {
        return valid1(s, 0, s.length() - 1, false);
    }

    public static boolean valid1(String s, int i, int j, boolean isDeep) {
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (a != b) {
                if (isDeep) {
                    return false;
                }
                return valid1(s, i, j - 1, true) || valid1(s, i + 1, j, true);
            }
            i++;
            j--;
        }
        return true;
    }

}