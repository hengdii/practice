package com.jiaty.demo.leecode.twice.easy;

/**
 * @program: practice
 * @description: 非递减序列
 * @author: Jiaty
 * @create: 2021-02-07 14:53
 **/

public class Solution665 {
    /**
     * wrong
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            count++;
        }
        if (count > 2) {
            return false;
        }
        return true;
    }

    public static boolean checkPossibility1(int[] nums){
        int n = nums.length,count = 0;
        for (int i = 0; i < n-1; i++) {
            int x = nums[i],y= nums[i +1];
            if (x > y){
                count++;
                if (count > 1){
                    return false;
                }
                if (i > 0 && y < nums[i-1]){
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}