package com.jiaty.demo.leecode.once.primary;

/**
 * @program: Practice
 * @description: 删除排序链表中的重复元素
 * @author: Jiaty
 * @create: 2020-08-04 16:45
 **/

public class Solution83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null &&head.val == head.next.val) {
            head.val = head.next.val;
            head.next = head.next.next;
            deleteDuplicates(head);
        }else {
            deleteDuplicates(head.next);
        }
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = "null";
            if (next != null) {
                s = next.toString();
            }
            return val + "->" + s;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);
        l1.next.next.next.next.next = new ListNode(3);
        System.out.println(l1.toString());
        System.out.println(deleteDuplicates1(l1));
    }

    /**
     * 别的写法
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates1(head.next);
        } else {
            head.next = deleteDuplicates1(head.next);
        }
        return head;
    }

    /**
     * 官方写法
     *
     * 这是一个简单的问题，仅测试你操作列表的结点指针的能力。由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
     * 如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)O(n)，其中 nn 是列表中的结点数。
     *
     * 空间复杂度：O(1)O(1)，没有使用额外的空间。
     *
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}