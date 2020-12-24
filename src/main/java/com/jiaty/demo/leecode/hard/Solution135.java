package com.jiaty.demo.leecode.hard;

/**
 * @program: practice
 * @description: 分发糖果
 * @author: Jiaty
 * @create: 2020-12-24 11:28
 **/

public class Solution135 {
    /**
     * 解法1;
     * 相邻的孩子中，评分高的孩子必须获得更多的糖果
     * <p>
     * 将这句话拆分成两个规则，分别处理
     * <p>
     * 左：当ratings[i-1] < ratings[i] 时，i 号学生的糖果数量将比 i -1 号孩子的糖果数量多
     * 右：当ratings[i] > ratings[i +1]时，i号学生的糖果数量将比i+ 1号孩子的糖果数量多
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}