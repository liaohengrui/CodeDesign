package com.example.linked_list;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/17
 */
public class CheckCycle {
    ListNode fastPoint;
    ListNode slowPoint;

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else {
            slowPoint = head;
        }
        if (head.next != null && head.next.next != null) {
            fastPoint = head.next.next;
        } else {
            return false;
        }
        while (!(fastPoint == null)) {
            if (fastPoint == slowPoint) {
                return true;
            } else {
                try {
                    slowPoint = slowPoint.next;
                    fastPoint = fastPoint.next.next;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        CheckCycle cycle = new CheckCycle();
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;
        System.out.println(cycle.hasCycle(listNode));
    }
}
