package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 为运算表达式设计优先级
 * @author: Jiaty
 * @create: 2020-09-17 17:07
 **/

public class Solution241 {
    /**
     * 递归，分治
     *
     * @param input
     * @return
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        diffWaysToCompute(input).forEach(System.out::println);
    }

}