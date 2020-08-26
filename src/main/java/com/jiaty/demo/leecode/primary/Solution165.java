package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 两数之和2：输入有序数组
 * @author: Jiaty
 * @create: 2020-08-25 17:08
 **/

public class Solution165 {


    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[j] + numbers[i];
            if (target < sum) {
                j--;
                continue;
            }
            if (target > sum) {
                i++;
                continue;
            }
            return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0};
        int target = -1;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}