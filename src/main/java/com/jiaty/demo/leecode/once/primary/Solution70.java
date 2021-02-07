package com.jiaty.demo.leecode.once.primary;

/**
 * @program: Practice
 * @description: 爬楼梯  TODO
 * @author: Jiaty
 * @create: 2020-08-04 17:59
 **/

public class Solution70 {
    /**
     * 斐波那契数列，但是这样会超时
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        System.out.println(climbStairs1(45));

    }

    public static int climbStairs1(int n){
        if (n == 1 || n == 2){
            return n;
        }
        int q = 1;
        int p = 2;
        int tmp = 0;
        for (int i = 2; i < n; i++) {
            tmp = q + p;
            q = p;
            p = tmp;
        }
        return tmp;
    }


}