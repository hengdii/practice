package com.jiaty.demo.leecode.once.intermediate;

/**
 * @program: Practice
 * @description: 盛最多水的容器
 * @author: Jiaty
 * @create: 2020-07-27 18:00
 **/

public class Solution11 {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     *  
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例：
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     **/


    public static int maxArea(int[] height) {
        int i = 0;
        int maxArea = 0;
        while (i < height.length) {
            int j = height.length - 1;
            while (i < j) {
                int width = j - i;
                int heigh = Math.min(height[i], height[j]);
                maxArea = Math.max(width * heigh, maxArea);
                j--;
            }
            i++;
        }
        return maxArea;
    }


    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 9, 7};
        System.out.println(maxArea(height));

    }


    /**
     * 题解的双指针法
     */
    public static int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            //这个才是核心 哪边高度低，那就挪一下
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}