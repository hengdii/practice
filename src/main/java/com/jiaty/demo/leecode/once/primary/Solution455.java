package com.jiaty.demo.leecode.once.primary;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 分发饼干
 * @author: Jiaty
 * @create: 2020-09-03 10:14
 **/

public class Solution455 {

    public static int findContentChildren(int[] kids, int[] cookies) {
        Arrays.sort(kids);
        Arrays.sort(cookies);
        int i = cookies.length - 1;
        int sum = 0;
        for (int j = kids.length - 1; j > -1; j--) {
            if (i > -1 && cookies[i] >= kids[j]) {
                i--;
                sum++;
            }
        }
        return sum;
    }

    public static int findContentChildren1(int[] kids, int[] cookies) {
        Arrays.sort(kids);
        Arrays.sort(cookies);
        int i = 0;
        int sum = 0;
        for (int j = 0; j > kids.length; j++) {
            if (cookies[i] >= kids[j]) {
                i++;
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] kids = new int[]{1, 2};
        int[] cookies = new int[]{1};
        System.out.println(findContentChildren(kids, cookies));
    }

}