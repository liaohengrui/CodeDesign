package com.example.DesignKey;

import com.example.hashmap.DuplicateArray;
import com.example.string.MaxOne;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/25
 */
public class DuplicateSubtrees {
    Map<String, TreeNode> map = new HashMap<>();
    Map<TreeNode, String> mapAssist = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversingTree(root);
        List list = new ArrayList();
        for (TreeNode treeNode : set) {
            list.add(treeNode);
        }
        return list;
    }

    private void traversingTree(TreeNode node) {
        if (node == null) {
            return;
        }
        traversingTree(node.left);
        traversingTree(node.right);
        String customizedInt = customizedKey(node);
        if (map.containsKey(customizedInt)) {
            set.add(map.get(customizedInt));
        } else {
            map.put(customizedInt, node);
        }
    }

    private String customizedKey(TreeNode node) {
        if (node.left != null || node.right != null) {
            String leftStr = "L#";
            String rightStr = "R#";
            StringBuffer buffer = new StringBuffer();
            if (node.left != null && node.right != null) {
                leftStr = mapAssist.get(node.left);
                rightStr = mapAssist.get(node.right);
                buffer.append(leftStr);
                buffer.append(node.val);
                buffer.append(rightStr);
            }else if (node.left == null ) {
                rightStr = mapAssist.get(node.right);
                buffer.append(leftStr);
                buffer.append(node.val);
                buffer.append(rightStr);
            }else  {
                leftStr = mapAssist.get(node.left);
                buffer.append(leftStr);
                buffer.append(node.val);
                buffer.append(rightStr);
            }
            String s=buffer.toString();
            mapAssist.put(node,s );
            return s;
        }
        Set set = new HashSet();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            if (treeNode.left != null) {
                if (set.add(treeNode.left)) {
                    stack.push(treeNode.left);
                } else {
                    TreeNode node1 = stack.pop();
                    buffer.append(node1.val);
                    if (node1.right != null) {
                        if (set.add(node1.right)) {
                            stack.push(node1.right);
                        }
                    } else {
                        buffer.append("R#");
                    }
                }
            } else {
                buffer.append("L#");
                TreeNode node1 = stack.pop();
                buffer.append(node1.val);
                if (node1.right != null) {
                    if (set.add(node1.right)) {
                        stack.push(node1.right);
                    }
                } else {
                    buffer.append("R#");
                }
            }
        }
        mapAssist.put(node, buffer.toString());
        return buffer.toString();
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
