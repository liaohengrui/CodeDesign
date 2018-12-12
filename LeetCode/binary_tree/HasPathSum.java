package com.example.binary_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/12
 */
public class HasPathSum {
    boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        hasPathSum(root, sum, 0);
        return result;
    }

    public void hasPathSum(TreeNode root, int sum, int current) {
        if (root.left != null) {
            hasPathSum(root.left, sum, current + root.val);
        }
        if (root.right != null) {
            hasPathSum(root.right, sum, current + root.val);
        }
        if (root.left == null && root.right == null) {
            if (current+root.val == sum) {
                result = true;
            }
        }
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
