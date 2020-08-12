package com.jiaty.demo.leecode.intermediate;

/**
 * @program: practice
 * @description: 最长回文子串
 * @author: Jiaty
 * @create: 2020-08-12 10:03
 **/

public class Solution5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */


    /**
     * 超过时间限制🚫
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (j - i + 1 < sb.length()) {
                    continue;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = i; k < j + 1; k++) {
                    stringBuilder.append(s.charAt(k));
                }
                if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
                    sb = stringBuilder.length() > sb.length() ? stringBuilder : sb;
                }
            }
            i++;
        }
        return sb.toString();
    }


    public static boolean isPalindrome(StringBuilder sb) {
        /**
         * 如果使用stringBuilder的reverse方法进行反转，一定要记住，反转了之后，stringBuilder本身就变化了
         * 所以  sb.reverse().toString() 去比较 sb.toString()
         *
         */
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return sb.reverse().toString().equals(sb.toString());
    }

    public static void main(String[] args) {

        String s = "abcda";
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(sb.reverse().toString());
//        System.out.println("adcba".equals("abcda"));
////        s
//        System.out.println(sb.reverse().toString().equals(sb.toString()));
        System.out.println(longestPalindrome(s));

        System.out.println(longestPalindrome1(s));

    }


    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    private static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}