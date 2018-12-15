package com.example.binary_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class PreorderAndInorder {
    public static void main(String[] args) {
        PreorderAndInorder builder = new PreorderAndInorder();
        TreeNode node = builder.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode buildTree(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2) {
        if (left1 == right1) {
            return new TreeNode(preorder[left1]);
        }
        if (left1 > right1) {
            return null;
        }
        int middleVal = preorder[left1];
        TreeNode middleNode = new TreeNode(middleVal);
        int middleIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == middleVal) {
                middleIndex = i;
                break;
            }
        }

        middleNode.left = buildTree(preorder, left1 + 1, left1 + middleIndex - left2, inorder, left2, middleIndex - 1);
        middleNode.right = buildTree(preorder, left1 + middleIndex - left2 + 1, right1, inorder, middleIndex + 1, right2);
        return middleNode;
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
