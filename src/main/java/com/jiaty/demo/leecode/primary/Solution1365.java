package com.jiaty.demo.leecode.primary;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 有多少小于当前数字的数字
 * @author: Jiaty
 * @create: 2020-10-26 13:45
 **/

public class Solution1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int times = 0;
            int othor = 0;
            while (othor < nums.length) {
                if (i == othor) {
                    othor++;
                    continue;
                }
                if (nums[othor] < nums[i]) {
                    times++;
                }
                othor++;
            }
            result[i] = times;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }


}