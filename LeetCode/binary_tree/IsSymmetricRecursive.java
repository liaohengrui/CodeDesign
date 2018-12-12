package com.example.binary_tree;

import org.omg.CORBA.IRObject;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/12
 */
public class IsSymmetricRecursive {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 != null && root2 == null) || (root2 != null && root1 == null)) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean judge1 = isSymmetric(root1.left, root2.right);
        boolean judge2 = isSymmetric(root1.right, root2.left);
        return judge1 && judge2;
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
