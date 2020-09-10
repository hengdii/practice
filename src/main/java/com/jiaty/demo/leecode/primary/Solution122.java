package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 买卖股票的最佳时机2
 * @author: Jiaty
 * @create: 2020-09-10 10:36
 **/

public class Solution122 {
    /**
     * 多次交易，同一天可以先卖出再买入
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

}