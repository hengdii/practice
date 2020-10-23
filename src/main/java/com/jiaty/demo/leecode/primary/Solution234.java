package com.jiaty.demo.leecode.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description: 回文链表
 * @author: Jiaty
 * @create: 2020-10-23 10:20
 **/

public class Solution234 {

    /**
     * 转化为线性表，然后使用双指针
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 1) {
            return true;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i++).equals(list.get(j--))) {
                return false;
            }
        }

        return true;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = next == null ? "null" : next.toString();
            return val + "->" + s;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(listNode));
    }

    /**
     * 快慢指针，翻转链表
     * 1.使用快慢双指针，快指针每次走两步，慢指针每次走一步，这样快指针到头时，慢指针刚好在中点位置。
     *
     * 2.并且在慢指针走的过程中，时时记录前继节点$pre,反转前半部分链表。
     *
     * 3.最后同时从中间向两端遍历判断是否相同即可。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            pre = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        fast = pre;
        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;


    }

}