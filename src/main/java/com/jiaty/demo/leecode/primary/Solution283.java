package com.jiaty.demo.leecode.primary;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 移动0
 * @author: Jiaty
 * @create: 2020-11-19 15:33
 **/

public class Solution283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */


    /**
     * 不符合题意，没有保持非零元素的相对顺序
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == 0 && nums[end] == 0) {
                end--;
            } else if (nums[start] == 0 && nums[end] != 0) {
                swap(nums, start, end);
                start++;
                end--;
            } else {
                start++;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 答案没问题，但是双指针写的太垃圾了
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else if (nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
    }


    /**
     * 优雅解法
     * <p>
     * 1。非零的往前挪
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    /**
     * 优雅解法：
     * 2。双指针
     */

    public static void moveZeroes3(int[] nums) {
        int i = 0;//统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {//如果当前数字是0就不操作
                i++;
            } else if (i != 0) {
                //否则，把当前数字放到最前面那个0的位置，然后再把
                //当前位置设为0
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }


}