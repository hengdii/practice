package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 字符串相加
 * @author: Jiaty
 * @create: 2020-08-03 13:50
 **/

public class Solution415 {
    /**
     * 415. 字符串相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * <p>
     * 注意：
     * <p>
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */

    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder("");
        int max = Math.max(num1.length(), num2.length());
        //处理成等长的字符串
        /**
         * 下次可以这样写
         * while(num1.length() < num2.length()) num1 = "0" + num1;
         * while(num2.length() < num1.length()) num2 = "0" + num2;
         *
         */
        if ( num1.length() == max){
            StringBuilder stringBuilder1 = new StringBuilder(num2).reverse();
            for (int i = 0; i < max - num2.length(); i++) {
                stringBuilder1.append("0");
            }
            num2 = stringBuilder1.reverse().toString();
        }else {
            StringBuilder stringBuilder1 = new StringBuilder(num1).reverse();
            for (int i = 0; i < max - num1.length(); i++) {
                stringBuilder1.append("0");
            }
            num1 = stringBuilder1.reverse().toString();
        }
        int ext = 0;
        for (int i = max - 1; i > -1; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            int sum = n1 + n2 + ext;
            ext = sum / 10;
            stringBuilder.append(sum % 10);
        }
        if (ext == 1){
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 官方解法
     * <p>
     * 算法流程： 设定 i，j 两指针分别指向 num1，num2 尾部，模拟人工加法；
     * <p>
     * 计算进位： 计算 carry = tmp // 10，代表当前位相加是否产生进位；
     * 添加当前位： 计算 tmp = n1 + n2 + carry，并将当前位 tmp % 10 添加至 res 头部；
     * 索引溢出处理： 当指针 i或j 走过数字首部后，给 n1，n2 赋值为 00，相当于给 num1，num2 中长度较短的数字前面填 00，以便后续计算。
     * 当遍历完 num1，num2 后跳出循环，并根据 carry 值决定是否在头部添加进位 11，最终返回 res 即可。
     * 复杂度分析：
     * <p>
     * 时间复杂度 O(max(M,N))O(max(M,N))：其中 MM，NN 为 22 数字长度，按位遍历一遍数字（以较长的数字为准）；
     * 空间复杂度 O(1)O(1)：指针与变量使用常数大小空间。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings1(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "51189";
        String num2 = "967895";
        System.out.println(addStrings(num1, num2));

    }
}