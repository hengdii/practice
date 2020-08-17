package com.jiaty.demo.leecode.intermediate;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 最接近的三数之和
 * @author: Jiaty
 * @create: 2020-08-17 15:47
 **/

public class Solution16 {

    /**
     * TODO Wrong
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = nums[0];
        int j = nums[1];
        int k = 2;

        while (k < nums.length && nums[k] <= target) {
            i = nums[k - 2];
            j = nums[k - 1];
            k++;
        }
        return i + j + nums[k - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 2;
        System.out.println(threeSumClosest(nums, target));


    }


}