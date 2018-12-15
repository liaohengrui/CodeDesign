package com.example.binary_tree;

import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class SerializeAndDeserialize {
    int i = 0;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        preRecurse(root, stringBuffer);
        return stringBuffer.toString();
    }

    private void preRecurse(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            buffer.append("#!");
        } else {
            buffer.append(root.val + "!");
            preRecurse(root.left, buffer);
            preRecurse(root.right, buffer);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("!");
        return createTree(strings);
    }



    public TreeNode createTree(String[] strings) {
        if (!strings[i].equals("#")) {
            TreeNode treeNode = new TreeNode(Integer.valueOf(strings[i]));
            i++;
            treeNode.left = createTree(strings);
            i++;
            treeNode.right = createTree(strings);
            return treeNode;
        } else {
            return null;
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

    public static void main(String[] args) {
        SerializeAndDeserialize demo = new SerializeAndDeserialize();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        String serialize = demo.serialize(node1);
        System.out.println(serialize);
        TreeNode treeNode = demo.deserialize(serialize);
        System.out.println(treeNode);
    }

}
