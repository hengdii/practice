package com.jiaty.demo.leecode.intermediate;

/**
 * @program: practice
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: Jiaty
 * @create: 2020-09-16 17:59
 **/

public class Solution34 {
    /**
     * Wrong  没有搞清楚边界，以及第一个和最后一个
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1 && target == nums[0]) {
            return new int[]{0, 0};
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid + 1 < nums.length && nums[mid + 1] == target) {
                    return new int[]{mid, mid + 1};
                } else if (mid - 1 > -1 && nums[mid - 1] == target) {
                    return new int[]{mid - 1, mid};
                } else {
                    return new int[]{mid, mid};
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 官方解法（二分查找）
     */
    public int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }


    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }


    /**
     * 大佬解法
     */
    public static int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //不能直接返回下标，应该继续向左边寻找，【left,mid -1】的区间里
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //因为上面的条件是left <= right ，所以到了这里肯定left > right
        //此时left 和 right 的位置关系是【right，left】
        //而且此时left 才是第一次元素出现的位置
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}