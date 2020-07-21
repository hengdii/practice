package com.jiaty.demo.leeCode.primary;

/**
 * @program: practice
 * @description: 整数反转
 * @author: jiaty
 * @create: 2020-01-06 14:34
 **/

public class Solution1 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * <p>
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */


    public static int reverse(int x) {
        int resultNum = 0;
        long longx = Long.parseLong(String.valueOf(x));
        StringBuilder sb = new StringBuilder();
        if (x == 0 || x != longx) {
            return resultNum;
        }
        if (x > 0) {
            char[] x1 = String.valueOf(x).toCharArray();
            for (int i = x1.length - 1; i >= 0; i--) {
                sb.append(x1[i]);
            }
            resultNum = Integer.valueOf(sb.toString());
        } else {
            char[] x2 = String.valueOf(x).toCharArray();
            for (int i = x2.length - 1; i >= 1; i--) {
                sb.append(x2[i]);
            }
            int i = Integer.parseInt(sb.toString());
            resultNum = -i;
        }
        return resultNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}