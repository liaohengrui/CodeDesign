package com.example.linked_list;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/21
 */
public class CheckPalindrome {
    ListNode headPoint;
    boolean result = true;

    public boolean isPalindrome(ListNode head) {
        headPoint = head;
        recursionCheck(head);
        return result;
    }

    public ListNode recursionCheck(ListNode head) {
        if (head == null) {
            result=false;
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = recursionCheck(head.next);
        if (node == null) {
            return null;
        }
        if (node.val == headPoint.val) {
            headPoint = headPoint.next;
            return head;
        } else {
            result = false;
            return null;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        CheckPalindrome palindrome = new CheckPalindrome();
        palindrome.isPalindrome(listNode1);
    }
}
