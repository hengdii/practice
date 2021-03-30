package com.jiaty.demo.leecode.twice.medium;

/**
 * @program: practice
 * @description: 删除链表的倒数第N个节点
 * @author: Jiaty
 * @create: 2021-03-24 01:42
 **/

public class Solution19 {

    private class ListNode {
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
    }

    /**
     *  错的
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while ((n - 1) != 0) {
            fast = fast.next;
            n--;
        }
        return removeNode(head, fast);
    }

    public ListNode removeNode(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return fast;
        }
        slow.next = removeNode(slow.next, fast.next);
        return slow;
    }

    /**
     * 正确的
     *
     */
    public ListNode removeNthFromEndRight(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i=0;i<n;++i){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}