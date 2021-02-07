package com.jiaty.demo.leecode.once.intermediate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: practice
 * @description: 二进制矩阵中的最短路径
 * @author: Jiaty
 * @create: 2020-09-18 18:16
 **/

public class Solution1091 {

    /**
     * 思路分析：
     * <p>
     * 要找到左上角到右下角的最短路径，最短路径嘛，自然就想到了使用BFS。
     * 在二维平面上，八个方向可以进行移动，使用int[][] directions表示八个方向。比如{1,1}就表示右下方向。二维平面常规做法，使用函数boolean inGrid(int x, int y)判断某个点是否在矩形范围内（防止数组越界）。
     * 首先将成员变量，表示矩形行列数的row, col初始化。然后如果左上角或者右下角为1，一定无法从左上角到右下角，直接返回-1。
     * 然后开始使用队列模拟BFS：
     * 我们需要去判断哪些路径已经走过，并且我们还需要知道走到某一个点时的步数，结合题目规定0是通行，1是不可通行，走过的点也不会再走相当于不可通行。所以我们可以用grid[newX][newY] == 0表示没有访问过的可通行的点。
     * 按照题意，起点也有长度1，所以设置grid[0][0] = 1;，且 pos.add(new int[]{0,0});。
     * 用队列模拟的循环条件!pos.isEmpty() && grid[row - 1][col - 1] == 0，第二个条件不满足时，说明已经有路径到达右下角了，就可以停止搜索。
     * 弹出某个点的坐标，通过int preLength = grid[xy[0]][xy[1]];得到到达该点的长度，然后遍历8个方向，试图访问下一个点，满足inGrid(newX, newY) && grid[newX][newY] == 0则可以访问，然后到达下一个点的路径长度就变为grid[newX][newY] = preLength + 1;，然后这个点grid[newX][newY] != 0了，就不会被重复访问。
     * 循环结束后，可能是搜索完成但没有到达右下角，此时grid[row - 1][col - 1] == 0；也可能是已经找到到达右下角的路径，按BFS，此时grid[row - 1][col - 1]即为答案。所以最后返回grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
     * 时间复杂度为O(n)O(n)，因为每个元素遍历了一次，n为元素的个数。空间复杂度为O(k)O(k)，k为过程中队列的最大元素个数。
     */

    private static int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int row, col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        Queue<int[]> pos = new LinkedList<>();
        // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        grid[0][0] = 1;
        pos.add(new int[]{0, 0});
        // 求最短路径 使用BFS
        while (!pos.isEmpty() && grid[row - 1][col - 1] == 0) {
            int[] xy = pos.remove();
            // 当前点的路径长度
            int preLength = grid[xy[0]][xy[1]];
            for (int i = 0; i < 8; i++) {
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    pos.add(new int[]{newX, newY});
                    // 下一个点的路径长度要+1
                    grid[newX][newY] = preLength + 1;
                }
            }
        }
        // 如果最后终点的值还是0，说明没有到达
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    private boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}