package com.example.binary_tree;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/11
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        System.out.println(new PostorderTraversal().postorderTraversal(node1));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        Set set = new HashSet();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.peek();
            if ((node.left == null || set.contains(node.left)) && (node.right == null || set.contains(node.right))) {
                set.add(node);
                nodes.add(node.val);
                treeNodes.pop();
                continue;
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
            if (node.left != null) {
                treeNodes.add(node.left);
            }
        }
        return nodes;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
