package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 爬楼梯
 * @author: Jiaty
 * @create: 2020-08-04 17:59
 **/

public class Solution70 {

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));

    }

}