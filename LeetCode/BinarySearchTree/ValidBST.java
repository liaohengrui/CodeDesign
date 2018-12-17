package com.example.binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/12
 */
public class ValidBST {
    Integer min;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left) || (min != null && root.val <= min)) {
            return false;
        }
        min = root.val;
        return isValidBST(root.right);
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
