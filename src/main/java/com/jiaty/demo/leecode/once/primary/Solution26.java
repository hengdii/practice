package com.jiaty.demo.leecode.once.primary;

/**
 * @program: Practice
 * @description: 删除排序数组中的重复项
 * @author: Jiaty
 * @create: 2020-07-27 16:50
 **/

public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                nums = deleteNums(nums, i - 1);
            }
        }
        return nums.length;
    }

    private static int[] deleteNums(int[] nums, int index) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < index) {
                nums[i] = nums[i];
            } else {
                nums[i] = nums[i + 1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
    }


    public static int removeDuplicates1(int[] nums) {
        int length = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                length = length - 1;
                for (int j = i - 1; j < length; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return length;
    }

    /**
     * 官方解法 ： 双指针法
     * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
     * <p>
     * 当我们遇到 nums[j] 不等于 nums[i]时，跳过重复项的运行已经结束，
     * 因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     */

    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}