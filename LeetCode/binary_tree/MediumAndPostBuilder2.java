package com.example.binary_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class MediumAndPostBuilder2 {

    public static void main(String[] args) {
        MediumAndPostBuilder2 builder = new MediumAndPostBuilder2();
        TreeNode node = builder.buildTree(new int[]{2, 1}, new int[]{2, 1});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int left1, int right1, int[] postorder, int left2, int right2) {
        if (left1 > right1) {
            return null;
        }
        if (left1 == right1) {
            return new TreeNode(inorder[left1]);
        }
        int middleVal = postorder[right2];
        TreeNode middleNode = new TreeNode(middleVal);
        int middleIndex = 0;
        for (int i = left1; i <= right1; i++) {
            if (inorder[i] == middleVal) {
                middleIndex = i;
                break;
            }
        }
        middleNode.left = buildTree(inorder, left1, middleIndex - 1, postorder, left2, left2 + middleIndex - left1 - 1);
        middleNode.right = buildTree(inorder, middleIndex + 1, right1, postorder, left2 + middleIndex - left1, right2 - 1);
        return middleNode;
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
