package com.jiaty.demo.leecode.once.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: practice
 * @description: Z字形变换
 * @author: Jiaty
 * @create: 2020-08-13 10:43
 **/

public class Solution6 {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public String convert(String s, int numRows) {
        int max = numRows + numRows - 1;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0;i<max)
        for (int i = 0; i < s.length() / max; i++) {
            for (int j = 0; j < s.length(); j++) {
//                stringBuilder.append(chars[])
            }
        }


        return "";
    }


    /**
     * 官方题解：
     * 1。按行排序
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }


    /**
     * 官方题解2：
     * 按行访问
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n - i; j += cycleLen) {
                ret.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert1(s, 8));
        System.out.println(convert2(s, 8));
        System.out.println(convert2(s, 8));
    }


    public static String convert3(String s, int numRows) {
        Vector<String> temp = new Vector<>(numRows);
        String res = "";
        if (s.length() == 0 || numRows < 1) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            int ans = i / (numRows - 1);
            int cur = i % (numRows - 1);
            if (ans % 2 == 0) {
                temp.insertElementAt(String.valueOf(s.charAt(i)), cur);
            }
            if (ans % 2 != 0) {
                temp.insertElementAt(String.valueOf(s.charAt(i)), numRows - cur - 1);
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            res += temp.elementAt(i);
        }
        return res;

    }


}