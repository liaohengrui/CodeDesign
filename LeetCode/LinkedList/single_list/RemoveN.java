package com.example.linked_list;

import com.example.linked_list.CycleLinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/18
 */
public class RemoveN {

    ListNode fast;
    ListNode slow;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1&&head.next==null) {
            return null;
        }
        //快的比慢的前面N个
        fast = head;
        slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                head = head.next;
                return head;
            }

        }
        while (!(fast.next == null)) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveN removeN = new RemoveN();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        System.out.println(removeN.removeNthFromEnd(node, 2));
    }
}
