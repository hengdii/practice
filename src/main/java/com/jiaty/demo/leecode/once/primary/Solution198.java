package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 打家劫舍
 * @author: Jiaty
 * @create: 2020-10-22 11:00
 **/

public class Solution198 {

    /**
     * 动态规划：
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }


    /**
     * 滚动数组
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组长度。只需要对数组遍历一次。
     *
     * 空间复杂度：O(1)O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是 O(1)O(1)。
     *
     *
     */
    public static int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}