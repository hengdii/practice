package com.jiaty.demo.leecode.primary;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 只出现一次的数字（特殊要求，不使用额外的空间，线性的时间复杂度）
 * @author: Jiaty
 * @create: 2020-10-21 16:07
 **/

public class Solution136 {
    /**
     * 使用了排序的库函数，方法不太行
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                i = i + 2;
                j = j + 2;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     *
     */
    public int singleNumber1(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


}