package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 平方数之和
 * @author: Jiaty
 * @create: 2020-08-26 10:20
 **/

public class Solution633 {
    /**
     * 笨办法
     * <p>
     * 里面用了Math.sqrt方法，可以返回一个这个值下面可以取到的平方的最大的值，可以有效的防止溢出。
     *      例如
     *      Math.sqrt(100) ，那么他就会返回10
     *      Math.sqrt(10)，那么他就会返回3.16... 强转成int就可以使用了
     *
     *
     * 大概的意思就是用了双指针，然后从0和当前可以取到的最大的防溢出的值开始。假如说平方和 > target，那就让end--；
     * 假如说平方和 < target，那就让start++；
     *
     * @param target
     * @return
     */
    public static boolean judgeSquareSum(int target) {
        int start = 0;
        int end = (int) Math.sqrt(target);
        while (start <= end) {
            int sum = end * end + start * start;
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(judgeSquareSum(999999999));
//        long i = 1000000L * 1000000L;

//        System.out.println(i);


        System.out.println((int)Math.sqrt(9999999999999999L));
        System.out.println(100000000 * 100000000);
    }

    /**
     * 二分查找！！！
     * <p>
     * 可以先定位二分查找的范围，target - 其中一个的平方  c-a^2
     */

    public static boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (binary_search(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n) {
            return true;
        }
        if (mid * mid > n) {
            return binary_search(s, mid - 1, n);
        }
        return binary_search(mid + 1, e, n);
    }


    /**
     * 主要使用了Math.sqrt这个方法，单指针，从最小的开始
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }


}