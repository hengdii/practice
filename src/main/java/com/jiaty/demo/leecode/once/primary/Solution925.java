package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 长按键入
 * @author: Jiaty
 * @create: 2020-10-21 11:48
 **/

public class Solution925 {
    /**
     * 没搞好
     */
    public static boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0) {
            return false;
        }
        if (name.equals(typed)) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            String type = typed.substring(j);
            if (type.indexOf(name.charAt(i)) < 0) {
                return false;
            }
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        char c = typed.charAt(j - 1);
        for (int k = j; k < typed.length(); k++) {
            if (c != typed.charAt(k)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String s = "alex";
//        String t = "aaleex";


        String s1 = "pyplrz";
        String s2 = "ppyypllr";

        System.out.println(isLongPressedName1(s1, s2));

    }

    public static boolean isLongPressedName1(String name, String typed) {
        if (name == null || name.length() == 0) {
            return false;
        }
        if (name.equals(typed)) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        if (i < name.length()) {
            return false;
        }
        int length = j - 1;
        for (int k = length; k < typed.length() - 1; k++) {
            if (typed.charAt(k) != typed.charAt(k + 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 更优解
     */
    public boolean isLongPressesName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}