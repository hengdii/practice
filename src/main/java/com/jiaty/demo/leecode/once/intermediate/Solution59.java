package com.jiaty.demo.leecode.once.intermediate;

import java.util.Arrays;

/**
 * @program: practice
 * @description: 螺旋矩阵II
 * @author: Jiaty
 * @create: 2021-04-08 23:34
 **/

public class Solution59 {

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int j = 0;
        while (count < n * n) {
            for (int i = j; i < n - j; i++) {
                arr[j][i] = count++;
            }

            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = count++;
            }

            for (int i = n - j - 2; i >= j; i--) {
                arr[n - j - 1][i] = count++;
            }
            for (int i = n - j - 2; i > j; i--) {
                arr[i][j] = count++;
            }

            j++;

        }
        return arr;

    }

    public static final int[][] DERECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = -1, cnt = 0, d = 0, total = n * n;
        while (cnt < total) {
            for (int k = 0; k < n; k++) {
                i = i + DERECTIONS[d % 4][0];
                j = j + DERECTIONS[d % 4][1];
                res[i][j] = ++cnt;
            }
            if (d % 2 == 0) {
                n--;
            }
            d++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix1(10)));

    }

}