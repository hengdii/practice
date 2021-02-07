package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 寻找比目标字母大的最小字母
 * @author: Jiaty
 * @create: 2020-09-14 16:34
 **/

public class Solution744 {

    public static char nextGreatestLetter(char[] letters, char target) {
        if (compare(letters[letters.length - 1], target) > 0) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (compare(letters[mid], target) >= 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start < letters.length ? letters[end] : letters[0];
    }

    private static int compare(char c, char target) {
        if (char2Int(target) == char2Int(c)) {
            return 0;
        } else if (char2Int(target) > char2Int(c)) {
            return 1;
        } else {
            return -1;
        }
    }


    private static int char2Int(char c) {
        return c - '0';
    }
}