package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 外观序列
 * @author: Jiaty
 * @create: 2020-08-06 14:56
 **/

public class Solution38 {

    /**
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     * <p>
     * 注意：整数序列中的每一项将表示为一个字符串。
     * <p>
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * <p>
     * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
     * <p>
     * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
     * <p>
     * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
     * <p>
     * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "1"
     * 解释：这是一个基本样例。
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "1211"
     * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
     */

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "21";
        }
        int i = 3;
        String s = "21";
        while (i != n) {
            s = append(s);
            i++;
        }
        return s;
    }

    public static String append(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = new String[s.length()];
        int j = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > -1; ) {
            if (i == 0) {
                ss[i] = "1" + chars[i];
                break;
            } else if (chars[i] == chars[i - 1] && chars[i] == chars[i - 2]) {
                ss[i] = "3" + chars[i];
                i = i - 2;
            } else if (chars[i] == chars[i - 1]) {
                ss[i] = "2" + chars[i];
                i = i - 1;
            } else if (chars[i] != chars[i - 1]) {
                ss[i] = "1" + chars[i];
            }
            j++;
            i--;
        }
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i] == null?"":ss[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(countAndSay1(n));
    }


    /**
     * 大佬解题：
     *  递归
     *
     */
    public static String countAndSay1(int n) {
        StringBuilder s = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if ( n == 1 ) {
            return "1";
        }
        String str = countAndSay(n - 1);
        for (; cur < str.length(); cur++ ) {
            if ( str.charAt(p1) != str.charAt(cur) ) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur - p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        if ( p1 != cur ){// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            int count = cur - p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();
    }
}