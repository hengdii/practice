package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 买卖股票的最佳时机
 * @author: Jiaty
 * @create: 2020-09-09 16:23
 **/

public class Solution121 {
    /**
     * 暴力解法
     *
     * 时间复杂度：O(n^2)  循环运行((n-1) * n) /2
     * <p>
     * 空间复杂度：O(1)。只使用了常数个变量。
     */
    public int maxProfit(int[] prices) {
        int tmp = 0;
        int start = 0;
        while (start < prices.length) {
            for (int end = start + 1; end < prices.length; end++) {
                tmp = Math.max(tmp, prices[end] - prices[start]);
            }
            start++;
        }
        return tmp;
    }

}