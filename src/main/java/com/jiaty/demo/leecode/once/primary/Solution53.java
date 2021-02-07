package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 最大子序和
 * @author: Jiaty
 * @create: 2020-08-06 14:22
 **/

public class Solution53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */


    /**
     * 在某种极端情况下，会超时，暴力破解太费劲
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int tmp = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = nums[k] + sum;
                }
                tmp = Math.max(tmp, sum);
                j++;
            }
            i++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2147483648, 1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));

        System.out.println( -1 + (-2147483648));
    }

    /**
     * 高端写法
     */
    public static int maxSubArray1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}