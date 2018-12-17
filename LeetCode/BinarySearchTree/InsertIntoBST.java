package com.example.binary_search_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/13
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val == val) {
            return null;
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return null;
            }
            insertIntoBST(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return null;
            }
            insertIntoBST(root.right, val);
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
