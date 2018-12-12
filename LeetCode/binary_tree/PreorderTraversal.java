package com.example.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/11
 */
public class PreorderTraversal {
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return nodes;
        }
        nodes.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return nodes;
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
