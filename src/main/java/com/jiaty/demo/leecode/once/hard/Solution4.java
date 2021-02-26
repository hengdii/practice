package com.jiaty.demo.leecode.once.hard;

/**
 * @program: practice
 * @description: 寻找两个正序数组的中位数
 * @author: Jiaty
 * @create: 2021-02-27 01:14
 **/

public class Solution4 {
    /**
     * 特别注意上述代码中 return  ans / 2.0; 这一行代码，为什么不能写成 ans/2，这是因为对于同样的一个值ans，除数不同时，结果也不同。谨记！！！！！
     * **5 / 2 = 2**
     * **5 / 2.0 = 2.5**。
     * @param nums1
     * @param nums2
     * @return
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int i = findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right);
        System.out.println(i);
        return  i/ 2;
    }

    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }


    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int i = findKth1(nums1, 0, nums2, 0, left) + findKth1(nums1, 0, nums2, 0, right);
        System.out.println(i);
        return  i/ 2.0;
    }

    public static int findKth1(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth1(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth1(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }


}