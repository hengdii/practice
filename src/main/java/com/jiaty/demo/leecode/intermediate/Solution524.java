package com.jiaty.demo.leecode.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: practice
 * @description: 通过删除字母来匹配到字典里最长单词
 * @author: Jiaty
 * @create: 2020-08-27 17:09
 **/

public class Solution524 {

    /**
     * 字典序最小
     * <p>
     * Collections.sort() ,对list中的字符串是按照字典顺序排序的
     * <p>
     * 还有就是String的compareTo方法,按字典顺序比较两个字符串。
     */

    public static String findLongestWord(String s, List<String> d) {
        String tmp = "";
        if (d == null || d.isEmpty()) {
            return tmp;
        }
        Collections.sort(d);
        char[] chars = s.toCharArray();
        for (String ds : d) {
            tmp = getLongString(chars, ds, tmp);
        }
        return tmp;
    }


    private static String getLongString(char[] chars, String ds, String tmp) {
        int sPoint = 0;
        int dPoint = 0;
        while (dPoint < ds.length() && sPoint < chars.length) {
            if (chars[sPoint] == ds.charAt(dPoint)) {
                sPoint++;
                dPoint++;
            } else {
                sPoint++;
            }
        }
        return dPoint != ds.length() ? tmp : ds.length() > tmp.length() ? ds : tmp;
    }


    public static void main(String[] args) {
        String s = "bab";
        List<String> list = Arrays.asList("ba", "ab", "a", "b");
        System.out.println(findLongestWord(s, list));

    }
}