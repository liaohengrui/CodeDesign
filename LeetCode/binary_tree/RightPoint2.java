package com.example.binary_tree;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class RightPoint2 {
    public static void main(String[] args) {
        RightPoint2 rightPoint = new RightPoint2();
        TreeLinkNode node = new TreeLinkNode(2);
        rightPoint.connect(node);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Queue<TreeLinkNode> temp = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeLinkNode node = nodes.poll();
                if (node.left != null) {
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    temp.offer(node.right);
                }
                if (!nodes.isEmpty()) {
                    TreeLinkNode nextNode = ((LinkedList<TreeLinkNode>) nodes).peekFirst();
                    node.next = nextNode;
                }
            }
            nodes = temp;
        }
    }


    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
