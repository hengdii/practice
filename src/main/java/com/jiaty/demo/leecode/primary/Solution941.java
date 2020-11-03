package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 有效的山脉数组
 * @author: Jiaty
 * @create: 2020-11-03 10:18
 **/

public class Solution941 {

    /**
     * 路走偏了  Wrong
     *
     * @param A
     * @return
     */
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        boolean flg = false;
        while (start < end && !flg) {
            mid = start + (end - start) / 2;
            if (mid > 0 && mid < A.length - 1) {
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    flg = true;
                } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                break;
            }
        }
        if (!flg) {
            return false;
        }
        int[] firstOne = new int[mid + 1];
        System.arraycopy(A, 0, firstOne, 0, mid + 1);
        int[] seconeOne = new int[A.length - mid];
        System.arraycopy(A, mid, seconeOne, 0, A.length - mid);
        for (int i = 1; i < firstOne.length; i++) {
            if (firstOne[i] <= firstOne[i - 1]) {
                return false;
            }
        }

        for (int i = 1; i < seconeOne.length; i++) {
            if (seconeOne[i] >= seconeOne[i - 1]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] A = new int[]{0, 2, 3, 3, 5, 2, 1, 0};
        System.out.println(validMountainArray(A));
    }


    /**
     * 双指针  不全面
     */
    public boolean vaildMountainArray1(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < A.length - 1) {
            if (A[start] < A[start + 1]) {
                start++;
            } else {
                return false;
            }
        }
        while (end > 1) {
            if (A[end] > A[end - 1]) {
                end--;
            } else {
                return false;
            }
        }
        return start == end;
    }


    public static boolean validMountainArray2(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        //从左边往右边找，一直找到山峰为止
        while (left + 1 < len && A[left] < A[left + 1]) {
            left++;
        }
        //从右边往左边找，一直找到山峰为止
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }


}