package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 岛屿的周长
 * @author: Jiaty
 * @create: 2020-10-30 19:45
 **/

public class Solution463 {
    /**
     * 来个笨办法，直接遍历整个数组，碰到0或者边界计数
     *
     * 因为只有一个岛屿，并且没有岛内湖，所以确定了所有的1都是相连的，并且不会存在同一条边对应两个以上的位置，
     * 只要找到岛屿边界的1并计数周围的边即可，遍历的是数组，边界也是有边的，所以只要周围是0，或者到达了数组边界，就会找到边
     *
     *
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }


}