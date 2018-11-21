package com.example.linked_list;


/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/19
 */
public class ReverseListRecursion {
    ListNode listNode;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        recursion(head);
        return listNode;
    }

    private ListNode recursion(ListNode head) {
        if (head.next == null) {
            listNode = head;
            return head;
        }
        ListNode newHead = recursion(head.next);
        newHead.next = head;
        head.next = null;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReverseListRecursion reverse = new ReverseListRecursion();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode nodek = reverse.reverseList(node);
        System.out.println(nodek);

    }
}
