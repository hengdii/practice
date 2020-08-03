package com.jiaty.demo.leecode.primary;

/**
 * @program: Practice
 * @description: 合并两个有序链表
 * @author: Jiaty
 * @create: 2020-08-03 16:41
 **/

public class Solution21 {
    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        if (l1.val > l2.val) {
            l.val = l2.val;
            l.next = new ListNode(l1.val);
        } else {
            l.val = l1.val;
            l.next = new ListNode(l2.val);
        }
        merge(l.next, l1.next, l2.next);
        return l;
    }

    public static void merge(ListNode l, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        if (l1.val > l2.val) {
            l.next = new ListNode(l2.val);
            l.next.next = l1.val;
        } else {
            l.next = new ListNode(l1.val);
        }
        merge(l.next, l1.next, l2.next);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String s = "null";
            if (next != null){
                s = next.toString();
            }
            return val + "->" + s;
        }
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(4);
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        System.out.println(l1.toString());
        System.out.println(mergeTwoLists(l1, l2));
//        System.out.println(l3.toString());
    }

}