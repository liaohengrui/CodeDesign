package com.example.binary_tree;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/15
 */
public class MediumAndPostBuilder {
    Set set = new HashSet();
    int last;

    public static void main(String[] args) {
        MediumAndPostBuilder builder = new MediumAndPostBuilder();
        TreeNode node = builder.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        last = postorder.length - 1;
        if (last < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            list.add(inorder[i]);
        }
        return buildTree(list, postorder);
    }

    public TreeNode buildTree(List<Integer> inorder, int[] postorder) {
        int middleVal = postorder[last];
        int middleIndex = inorder.indexOf(middleVal);
        TreeNode middleNode = new TreeNode(middleVal);
        set.add(middleVal);
        List<Integer> leftInorder = createLeft(middleIndex - 1, inorder);
        List<Integer> rightInorder = createRight(middleIndex + 1, inorder);
        if (rightInorder.size() != 0) {
            last--;
            middleNode.right = buildTree(rightInorder, postorder);
        }
        if (leftInorder.size() != 0) {
            last--;
            middleNode.left = buildTree(leftInorder, postorder);
        }

        return middleNode;
    }

    private List<Integer> createRight(int i, List<Integer> inorder) {
        List<Integer> list = new ArrayList<>();
        while (i < inorder.size() && !set.contains(inorder.get(i))) {
            list.add(inorder.get(i));
            i++;
        }

        return list;
    }

    private List<Integer> createLeft(int i, List<Integer> inorder) {
        List<Integer> list = new ArrayList<>();
        while (i >= 0 && !set.contains(inorder.get(i))) {
            list.add(inorder.get(i));
            i--;
        }
        Collections.reverse(list);
        return list;
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
