package com.jiaty.demo.leecode.intermediate;

import java.util.Stack;

/**
 * @program: practice
 * @description: 删除链表的倒数第N个节点
 * @author: Jiaty
 * @create: 2020-09-21 17:53
 **/

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        ListNode listNode = new ListNode(0);
        while (!stack.isEmpty()) {
            for (int i = 1; i < stack.size() - 1; i++) {
                Integer pop = stack.pop();
                if (i == n) {
                    continue;
                }
                listNode.next = new ListNode(pop);
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + next == null ? "null" : next.toString();
        }
    }

    /**
     * 大佬解法： 一次遍历
     */

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
//
//    public static void main(String[] args) {
//
//
//    }




    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null){
            return null;
        }
        return head;
    }

}