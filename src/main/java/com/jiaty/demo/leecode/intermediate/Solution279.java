package com.jiaty.demo.leecode.intermediate;

/**
 * @program: practice
 * @description: 完全平方数
 * @author: Jiaty
 * @create: 2020-09-22 16:25
 **/

public class Solution279 {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     * <p>
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */


    /**
     * 菜鸡！！！！
     */
    public static int numSquares(int n) {
        int rest = n;
        int times = 0;

        while (rest != 0) {
            rest = rest(n, rest, times);
        }
        return times;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int numSquares1(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static int rest(int n, int rest, int times) {
        return 0;
    }
}