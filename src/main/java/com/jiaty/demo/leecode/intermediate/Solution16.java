package com.jiaty.demo.leecode.intermediate;

import java.util.*;

/**
 * @program: practice
 * @description: 最接近的三数之和
 * @author: Jiaty
 * @create: 2020-08-17 15:47
 **/

public class Solution16 {

    /**
     * TODO Wrong
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> threeNums = new ArrayList<>();
        Set<Integer> j = new HashSet<>();
        for (int i = nums.length - 1; i > 0; i--) {
            if (threeNums.size() == 3) {
                break;
            }
            if (nums[i] <= target) {
                threeNums.add(nums[i]);
                j.add(i);
                target -= nums[i];
            } else if (nums[i] > target) {
                continue;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!j.contains(i) && nums[i] <= target) {
                if (threeNums.size() != 3) {
                    threeNums.add(nums[i]);
                    j.add(i);
                } else {
                    break;
                }
            }
        }
        return threeNums.get(0) + threeNums.get(1) + threeNums.get(2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
//        System.out.println(threeSumClosest(nums, target));
        System.out.println(threeSumClosest1(nums, target));

    }

    /**
     * 双指针法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        int sumCloset = 10000;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length - 1;
            int sum = 0;
            while (left < i && right > i) {
                sum = nums[i] + nums[left] + nums[right];
                sumCloset = (Math.abs(sumCloset - target) > Math.abs(sum - target)) ? sum : sumCloset;
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return sumCloset;
    }

    /**
     * 官方解法
     */
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}