package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 合并两个有序数组
 * @author: Jiaty
 * @create: 2020-08-04 11:41
 **/

public class Solution88 {
    /**
     * 使用另一个数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1 = nums2;
        } else if (n == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = 0;
        int[] nums = new int[nums1.length];
        int prve = 0;
        int key;
        while (i != m && j != n) {
            if (nums1[i] > nums2[j]) {
                key = nums2[j];
                j++;
            } else {
                key = nums1[i];
                i++;
            }
            nums[prve] = key;
            prve++;
        }
        if (m - i != 0 || n - j != 0) {
            for (int k = 0; k < Math.max(m - i, n - j); k++) {
                if (m - i == 0) {
                    nums[prve] = nums2[j + k];
                } else {
                    nums[prve] = nums1[i + k];
                }
                prve++;
            }
        }
        nums1 = nums;
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 5, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 2};
        int m = 3;
        int n = 3;
        merge2(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }

    /**
     * 强行排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            merge2To1(nums2[i], nums1, m);
            m++;
        }
    }


    public static void merge2To1(int n, int[] nums1, int m) {
        int key = -1;
        for (int i = 0; i < m; i++) {
            if (i + 1 == m) {
                if (nums1[i] < n) {
                    nums1[m] = n;
                } else {
                    nums1[m] = nums1[i];
                    nums1[i] = n;
                }
            } else if (nums1[i] >= n) {
                key = i;
                break;
            }
        }
        if (key >= 0) {
            for (int i = m - 1; i >= key; i--) {
                nums1[i + 1] = nums1[i];
            }
            nums1[key] = n;
        }
    }

    /**
     * 新创建出一个数组，双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i >= m) {
                nums[k] = nums2[j];
                j++;
                continue;
            }
            if (j >= n) {
                nums[k] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

}