package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 加一
 * @author: Jiaty
 * @create: 2020-08-10 16:12
 **/

public class Solution66 {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int tmp = 1;
        for (int i = length - 1; i > -1; i--) {
            digits[i] = digits[i] + tmp;
            if (digits[0] > 9) {
                int[] newint = new int[length + 1];
                newint[0] = 1;
                newint[1] = digits[0] % 10;
                System.arraycopy(digits, 1, newint, 2, length - 1);
                return newint;
            }
            if (digits[i] > 9) {
                digits[i] = digits[i] % 10;
                tmp = 1;
            } else {
                tmp = 0;
            }
        }
        return digits;
    }

    public static void main(String[] args) {


    }

}