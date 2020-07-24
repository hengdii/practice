package com.jiaty.demo.leeCode.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Practice
 * @description: 翻译罗马数字
 * @author: Jiaty
 * @create: 2020-07-23 14:24
 **/

public class Solution13 {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    private static Map romanNumber = new HashMap();

    static {
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);
    }


    public static int romanToInt(String s) {
        //记住，不要用toCharArray，因为占用空间成了一个新的char数组
//        char[] chars = s.toCharArray();
        //直接用string.charAt
        int number = 0;
        int length = s.length();
        for (int i = 1; i < s.length(); i++) {
            int latter = (int) romanNumber.get(s.charAt(length - i));
            int previous = (int) romanNumber.get(s.charAt(length - i - 1));
            if (latter <= previous) {
                number = number + latter;
            } else {
                number = number + latter - previous - previous;
            }
        }
        number = number + (int) romanNumber.get(s.charAt(0));
        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCIV"));
    }

    /**
     * 先累加，然后再减
     *
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        char[] chars = s.toCharArray();
        int number = 0;
        for (int i = 0; i < chars.length; i++) {
            number = number + (int) romanNumber.get(chars[i]);
        }
        for (int i = chars.length - 1; i > 0; i--) {
            int latter = (int) romanNumber.get(chars[i]);
            int previous = (int) romanNumber.get(chars[i - 1]);
            if (latter > previous) {
                number = number - (previous * 2);
            }
        }
        return number;
    }

}