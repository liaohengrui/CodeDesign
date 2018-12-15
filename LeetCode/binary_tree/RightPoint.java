package com.example.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class RightPoint {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> list = new ArrayList();
        if (root == null) {
            return;
        }
        list.add(root);
        connect(list);
    }

    public void connect(List<TreeLinkNode> root) {
        List<TreeLinkNode> childRoot = new ArrayList<>();
        for (int i = 0; i < root.size(); i++) {
            TreeLinkNode node = root.get(i);
            if (node.left != null) {
                node.left.next = node.right;
                childRoot.add(node.left);
                childRoot.add(node.right);
                if (i != root.size() - 1) {
                    node.right.next = root.get(i + 1).left;
                }
            }
        }
        if (childRoot.size() != 0) {
            connect(childRoot);
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
