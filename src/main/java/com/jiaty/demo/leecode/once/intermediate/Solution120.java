package com.jiaty.demo.leecode.once.intermediate;


import java.util.List;

/**
 * @program: practice
 * @description: 三角形最小路径和
 * @author: Jiaty
 * @create: 2021-03-22 15:13
 **/

public class Solution120 {
    /**
     * 1。递归
     * <p>
     * 会超时
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return dfs1(triangle, 0, 0);
    }

    public int dfs1(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs1(triangle, i + 1, j), dfs1(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }


    /**
     * 2.递归 加 记忆化数组
     *
     * @param triangle
     * @return
     */

    Integer[][] memo;

    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs2(triangle, 0, 0);
    }

    public int dfs2(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(dfs2(triangle, i + 1, j), dfs2(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        return memo[i][j];
    }

    /**
     * 3.动态规划
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 4.动态规划
     */
    public int minimumTotal4(List<List<Integer>> triangle){
        int n = triangle.size();
        int [] dp = new int[n+1];
        for (int i =n-1;i>=0;i--){
            for (int j = 0;j<=i;j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

