package com.jiaty.demo.leecode.intermediate;

/**
 * @program: practice
 * @description: 两两交换链表中的节点
 * @author: Jiaty
 * @create: 2020-10-13 10:22
 **/

public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
    }

}