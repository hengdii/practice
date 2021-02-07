package com.jiaty.demo.leecode.once.intermediate;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 寻找旋转排序数组中的最小值
 * @author: Jiaty
 * @create: 2020-09-16 13:59
 **/

public class Solution153 {
    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //这个是和最右边比，如果比最右边小，说明最小值在mid的左边
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                //如果比最右边大，说明最小值在mid的右边
                start = mid + 1;
            }
        }
        return nums[start];
    }

    /**
     * 库函数
     *
     * @param nums
     * @return
     */
    public static int findMin1(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));

    }

}