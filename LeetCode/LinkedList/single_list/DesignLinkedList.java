package com.example.linked_list;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/17
 */
public class DesignLinkedList {
    Node head;
    int size;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        try {
            return getNode(index).val;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node tailNode = new Node(val);
        if (head == null) {
            head = tailNode;
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = tailNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == size ) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node original = getNode(index - 1);
            if (original == null) {
                return;
            }
            node.next = original.next;
            original.next = node;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node prev = getNode(index - 1);
        if (prev == null||prev.next==null) {
            return;
        }
        if (prev.next.next == null) {
            prev.next = null;
        } else {
            prev.next = prev.next.next;
        }
        size--;
    }

    private Node getNode(int index) {
        Node node = head;
        if (node == null) {
            return node;
        } else {
            for (int i = 0; i < index; i++) {
                try {
                    node = node.next;
                } catch (Exception e) {
                    return null;
                }
            }
            return node;
        }
    }


    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DesignLinkedList obj = new DesignLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));
    }
}
