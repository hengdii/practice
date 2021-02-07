package com.jiaty.demo.leecode.once.primary;

import java.util.PriorityQueue;

/**
 * @program: practice
 * @description: 最后一块石头的重量
 * @author: Jiaty
 * @create: 2020-12-30 18:33
 **/

public class Solution1046 {
    /**
     * 最大堆
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            queue.offer(s);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }


}