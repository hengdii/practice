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
        long resultNum;
        StringBuilder sb = new StringBuilder();
        if (x == 0 || x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        if (x > 0) {
            char[] x1 = String.valueOf(x).toCharArray();
            for (int i = x1.length - 1; i >= 0; i--) {
                sb.append(x1[i]);
            }
            resultNum = Long.parseLong(sb.toString());
            if (resultNum >= Integer.MAX_VALUE) {
                resultNum = 0L;
            }
        } else {
            char[] x2 = String.valueOf(x).toCharArray();
            for (int i = x2.length - 1; i >= 1; i--) {
                sb.append(x2[i]);
            }
            resultNum = Long.parseLong(sb.toString());
            resultNum = -resultNum;
            if (resultNum <= Integer.MIN_VALUE) {
                resultNum = 0L;
            }

        }
        return (int) resultNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(-123));
        System.out.println(reverse3(-123));
    }

    /**
     * 使用long类型和int(x)==x 来判断是否
     *
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    /**
     * 官方解法
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 利用StringBuilder 的 reverse
     * @param x
     * @return
     */
    public static int reverse3(int x){
        StringBuilder reverse = new StringBuilder(String.valueOf(x)).reverse();
        int flag = 1;
        if (x<0){
            flag = -1;
        }

        return 0;
    }
}