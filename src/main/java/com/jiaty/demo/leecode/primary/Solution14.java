package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 最长公共前缀
 * @author: Jiaty
 * @create: 2020-07-23 15:59
 **/

public class Solution14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     */


    /**
     * 暴力解法，直接将所有的数组的长度进行排序，找到最短的长度保证不会数组下标越界，然后用第一个字符串的字母开始遍历，发现不对就跳出循环
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder s = new StringBuilder();
//        Set<Integer> lengthSet = new HashSet<>();
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
//        List<Integer> collect = lengthSet.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
//        int minlength = collect.get(0);
        for (int i = 0; i < minLength; i++) {
            boolean flg = true;
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length - 1; j++) {
                char c1 = strs[j + 1].charAt(i);
                if (c != c1) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                s.append(c);
            } else {
                break;
            }
        }
        return s.toString();
    }


    public static void main(String[] args) {
        String[] s = new String[]{"aca", "cba"};
        System.out.println(longestCommonPrefix(s));
    }


    /**
     * 官方解法
     *
     *  用第一个字符，去和另外的比较，取出他们的公共前缀，然后再拿这个公共前缀去和第3个字符串比较，再拿出公共前缀
     * 时间复杂度O(mn)
     * 空间复杂度O(1)
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    /**
     * 这个的想法和我写的差不多，但是他的想法更好，因为他去判断了一下i == strs[j].length 如果要是到了这一步的话，说明已经遇到了最短的那个字符，而且最短的这个字符就是最长的公共前缀！！
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     *
     * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
