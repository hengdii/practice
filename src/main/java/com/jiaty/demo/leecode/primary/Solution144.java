package com.jiaty.demo.leecode.primary;

/**
 * @program: practice
 * @description: 环形链表
 * @author: Jiaty
 * @create: 2020-08-27 14:41
 **/

public class Solution144 {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(hasCycle(listNode));

    }
}