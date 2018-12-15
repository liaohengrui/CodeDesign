package com.example.binary_tree;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class PublicAncestor {
    List<TreeNode> list1 = new ArrayList();
    boolean flag = true;

    public static void main(String[] args) {
        PublicAncestor ancestor = new PublicAncestor();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        TreeNode node = ancestor.lowestCommonAncestor(node3, node5, node1);
        System.out.println(node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p);
        List listP = new ArrayList(list1);
        list1.clear();
        flag = true;
        search(root, q);
        List listQ = new ArrayList(list1);
        int min = listP.size() > listQ.size() ? listQ.size() : listP.size();
        int result = -1;
        for (int i = 0; i < min; i++) {
            if (listP.get(i) != listQ.get(i)) {
                break;
            }
            result = i;
        }
        if (result != -1) {
            return (TreeNode) listP.get(result);
        }
        return null;
    }

    private void search(TreeNode root, TreeNode p) {
        if (flag) {
            if (root == null) {
                return;
            }
            list1.add(root);
            if (root.val == p.val) {
                if (flag) {
                    flag = false;
                }
                return;
            }
            search(root.left, p);
            search(root.right, p);
            if (flag) {
                list1.remove(list1.size() - 1);
            }
        }
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
