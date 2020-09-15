package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 有序数组中的单一元素
 * @author: Jiaty
 * @create: 2020-09-15 10:45
 **/

public class Solution540 {
    /**
     * 暴力解法，时间复杂度，O(n)
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i = i + 2;
            } else {
                break;
            }
        }
        return nums[i];
    }


    /**
     * 二分查找法
     */
    public static int singleNonDuplicate1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                i = mid + 2;
            } else {
                j = mid;
            }
        }
        return nums[j];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate1(nums));
    }

}