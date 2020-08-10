package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 二进制求和
 * @author: Jiaty
 * @create: 2020-08-10 16:36
 **/

public class Solution67 {

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * <p>
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *  
     * <p>
     * 提示：
     * <p>
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     */

    public static String addBinary(String a, String b) {
        while (a.length() < b.length()) {
            a = "0" + a;
        }
        while (a.length() > b.length()) {
            b = "0" + b;
        }
        int tmp = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = a.length() - 1; i > -1; i--) {
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';
            int j = num1 + num2 + tmp;
            sb.append(j % 2);
            if (i == 0) {
                if (j > 1) {
                    sb.append("1");
                    return sb.reverse().toString();
                } else {
                    return sb.reverse().toString();
                }
            }
            if (j > 1) {
                tmp = 1;
            } else {
                tmp = 0;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));

    }
}