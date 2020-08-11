package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: x的平方根
 * @author: Jiaty
 * @create: 2020-08-10 17:20
 **/

public class Solution69 {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */

    /**
     * 二分查找。用x/mid 来防止溢出
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        if (x == 0) {
            return 0;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (x/mid == mid) {
                return mid;
            } else if (x/mid > mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start - 1;
    }


    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(mySqrt(x));
        System.out.println(46340 * 46340);
    }

}