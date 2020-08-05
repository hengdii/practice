package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 实现strStr() java 中的indexOf()  TODO
 * @author: Jiaty
 * @create: 2020-07-29 17:33
 **/

public class Solution28 {
    /**
     * 利用sybString来达到滑动窗口的效果
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int length = needle.length();
        for (int i = 0; i < haystack.length() - length +1; i++) {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s1 = "hellaolls";
        String s2 = "lls";
        System.out.println(strStr(s1,s2));

    }

    /**
     * 官方题解
     *
     * 子串逐一比较的解法最简单，将长度为 L 的滑动窗口沿着 haystack 字符串逐步移动，并将窗口内的子串与 needle 字符串相比较，时间复杂度为 O((N - L)L)O((N−L)L)
     *
     * 显示上面这个方法是可以优化的。双指针方法虽然也是线性时间复杂度，不过它可以避免比较所有的子串，因此最优情况下的时间复杂度为 O(N)O(N)，但最坏情况下的时间复杂度依然为 O((N - L)L)O((N−L)L)。
     *
     * 有 O(N)O(N) 复杂度的解法嘛？答案是有的，有两种方法可以实现：
     *
     * Rabin-Karp，通过哈希算法实现常数时间窗口内字符串比较。
     *
     * 比特位操作，通过比特掩码来实现常数时间窗口内字符串比较。
     *
     * 方法一：子串逐一比较-线性时间复杂度
     *      最直接的方法 - 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较
     *
     * 方法二：双指针法 - 线性时间复杂度
     *      简单说就是暴力破解
     *
     * 方法三：RK算法 - 常数复杂度
     *
     * 思路：先生成窗口内子串的哈希码，然后再跟 needle 字符串的哈希码做比较。
     */

}