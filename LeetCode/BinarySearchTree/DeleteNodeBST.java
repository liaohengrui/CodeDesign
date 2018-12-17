package com.example.binary_search_tree;

import java.sql.PseudoColumnUsage;
import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/13
 */
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            if (root.right == null && root.left != null) {
                return root.left;
            }
            TreeNode replaceNode = findMinNode(root.right);
            root.val = replaceNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }


    public TreeNode findMinNode(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMinNode(root.left);
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
