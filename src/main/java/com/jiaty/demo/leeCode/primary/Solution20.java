package com.jiaty.demo.leeCode.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: Practice
 * @description: 有效的括号
 * @author: Jiaty
 * @create: 2020-07-27 15:31
 **/

public class Solution20 {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('(', -1);
        map.put(')', 1);
        map.put('{', -2);
        map.put('}', 2);
        map.put('[', -3);
        map.put(']', 3);
    }

    /**
     * 思考错了方向
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (!isValidChar(i, s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChar(int i, String s) {
        Integer integer = map.get(s.charAt(i));
        Integer integer2 = map.get(s.charAt(i + 1));
        Integer integer1 = map.get(s.charAt(s.length() - 1 - i));
        return integer + integer2 == 0 || integer + integer1 == 0;
    }


    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValidStack(s));
    }


    public static boolean isValidStack(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 || stack.isEmpty()) {
                stack.push(c);
            } else {
                int value = map.get(c);
                int valueFromStack = map.get(stack.peek());
                if (value + valueFromStack == 0) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();

    }


}