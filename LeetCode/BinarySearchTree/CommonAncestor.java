package com.example.binary_search_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/17
 */
public class CommonAncestor {
    //p小,q大
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode swap = p;
            p = q;
            q = swap;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
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
