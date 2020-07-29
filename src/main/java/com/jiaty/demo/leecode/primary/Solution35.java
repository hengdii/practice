package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 搜索插入位置
 * @author: Jiaty
 * @create: 2020-07-17 12:45
 **/

public class Solution35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        if (nums[0]>=target){
            return 0;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                return j;
            }
            if (j != 0 && nums[j - 1] < target && nums[j] > target) {
                i = j;
            }
        }
        if (i != 0) {
            return i;
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));

    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                // 相关逻辑
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 相关返回值
        return left;
    }

    /**
     * 二分查找的模版
     *
     *    public int searchInsert(int[] nums, int target) {
     *         int left = 0, right = nums.length - 1; // 注意
     *         while(left <= right) { // 注意
     *             int mid = (left + right) / 2; // 注意
     *             if(nums[mid] == target) { // 注意
     *                 // 相关逻辑（需添加）
     *             } else if(nums[mid] < target) {
     *                 left = mid + 1; // 注意
     *             } else {
     *                 right = mid - 1; // 注意
     *             }
     *         }
     *         // 相关返回值（需修改）
     *         return 0;
     *     }
     *
     * 或
     *
     *
     *    public int searchInsert(int[] nums, int target) {
     *         int left = 0, right = nums.length; // 注意
     *         while(left < right) { // 注意
     *             int mid = (left + right) / 2; // 注意
     *             if(nums[mid] == target) {
     *                 // 相关逻辑（需添加）
     *             } else if(nums[mid] < target) {
     *                 left = mid + 1; // 注意
     *             } else {
     *                 right = mid; // 注意
     *             }
     *         }
     *         // 相关返回值（需修改）
     *         return 0;
     *     }
     *
     */
}