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
public class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int currentIndex = 0;

    public BSTIterator(TreeNode root) {
        recurseBST(root);
    }

    private void recurseBST(TreeNode root) {
        if (root == null) {
            return;
        }
        recurseBST(root.left);
        list.add(root.val);
        recurseBST(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int i = list.get(currentIndex);
        currentIndex++;
        return i;
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
