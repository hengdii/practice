package com.jiaty.demo.leeCode.intermediate;

/**
 * @program: Practice
 * @description: 盛最多水的容器
 * @author: Jiaty
 * @create: 2020-07-27 18:00
 **/

public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length;
        int area = 0;
        while (i < j) {
            int high = Math.max(height[i], height[j]);
            int width = j-i;
            area = high * width;
//            if (area > maxArea())
        }

        return 0;
    }

}