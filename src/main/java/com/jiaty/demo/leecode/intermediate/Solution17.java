package com.jiaty.demo.leecode.intermediate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: practice
 * @description: 电话号码的字母组合
 * @author: Jiaty
 * @create: 2020-08-19 10:02
 **/

public class Solution17 {

    /**
     * 回溯算法：
     * 回溯算法是一种通过琼剧所有可能情况来找到所有解的算法。如果一个候选解最后被发现不是可行解，回溯算法会舍弃他，
     * 并且在前面的一些步骤做出一些修改，并重新尝试找到可行解
     * <p>
     * 官方题解说这种做法是回溯，但是我看就是纯粹的递归....
     * <p>
     * 官方：
     * 给出如下回溯函数BackTrack(Combination,next_digits)，
     * 它将一个目前已经产生的组合combination和接下来准备输入的数字next_digits作为参数
     * <p>
     * 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了
     * 如果还有数字需要被输入
     * 遍历下一个数字所对应的所有映射的字母
     * 将当前的字母添加到组合最后，也就是combination = combination + letter
     * 重复这个过程，输入剩下的数字
     */

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> output = new ArrayList<String>();

    /**
     * 官方题解：
     *
     * 时间复杂度：O(3的N次方  *  4的M次方)，N：输入数字中对应3个字母的数目。M：输入数字中对应4个字母的数目。 N+M是输入数字的总数
     * <p>
     * 空间复杂度 O(3的N次方  *  4的M次方)，这是因为需要保存这么多个结果
     *
     * @param combination
     * @param next_digits
     */
    public static void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        String digits = "24";
        System.out.println(letterCombinations(digits));


    }

}