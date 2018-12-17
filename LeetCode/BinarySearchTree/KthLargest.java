package com.example.binary_search_tree;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/17
 */
public class KthLargest {
    int k;
    final int kk;
    BinarySearchTree searchTree;
    int result = -1;


    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        System.out.println(kthLargest.searchTree);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));

    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.kk = k;
        this.searchTree = createTree(nums);
    }

    public int add(int val) {
        k = kk;
        result = -1;
        addNum(val);
        BinarySearchTree tree = searchTree;
        add(tree);
        return result;
    }

    private void add(BinarySearchTree searchTree) {
        if (searchTree.count >= k) {
            if (k == 1 && searchTree.count == 1) {
                result = searchTree.val;
                return;
            }
            int temp = searchTree.right == null ? 0 : searchTree.right.count;
            if (k == temp + 1) {
                result = searchTree.val;
                return;
            }
            if (searchTree.right != null) {
                add(searchTree.right);
            }
            if (result == -1) {
                temp = searchTree.right == null ? 0 : searchTree.right.count;
                k -= (temp + 1);
                add(searchTree.left);
            }
        }
    }

    private void addNum(int val) {
        BinarySearchTree searchTree = this.searchTree;
        if (searchTree == null) {
            searchTree = new BinarySearchTree(val);
            searchTree.count = 1;
            this.searchTree = searchTree;
        } else {
            searchTree.count++;
            while (true) {
                if (val == searchTree.val) {
                    BinarySearchTree node = new BinarySearchTree(val);
                    node.right = searchTree.right;
                    int temp = searchTree.right == null ? 0 : searchTree.right.count;
                    node.count = temp + 1;
                    searchTree.right = node;
                    break;
                }
                if (val > searchTree.val) {
                    if (searchTree.right == null) {
                        searchTree.right = new BinarySearchTree(val);
                        searchTree.right.count++;
                        break;
                    } else {
                        searchTree = searchTree.right;
                        searchTree.count++;
                    }
                } else {
                    if (searchTree.left == null) {
                        searchTree.left = new BinarySearchTree(val);
                        searchTree.left.count++;
                        break;
                    } else {
                        searchTree = searchTree.left;
                        searchTree.count++;
                    }
                }
            }
        }
    }

    private BinarySearchTree createTree(int[] nums) {
        BinarySearchTree searchTree = null;
        BinarySearchTree returnSearchTree = null;
        for (int i : nums) {
            if (searchTree == null) {
                searchTree = new BinarySearchTree(i);
                searchTree.count = 1;
                returnSearchTree = searchTree;
                continue;
            }
            searchTree = returnSearchTree;
            searchTree.count++;
            while (true) {
                if (i > searchTree.val) {
                    if (searchTree.right == null) {
                        searchTree.right = new BinarySearchTree(i);
                        searchTree.right.count++;
                        break;
                    } else {
                        searchTree = searchTree.right;
                        searchTree.count++;
                    }
                } else {
                    if (searchTree.left == null) {
                        searchTree.left = new BinarySearchTree(i);
                        searchTree.left.count++;
                        break;
                    } else {
                        searchTree = searchTree.left;
                        searchTree.count++;
                    }
                }
            }
        }
        return returnSearchTree;
    }

    class BinarySearchTree {
        int val;
        int count;
        BinarySearchTree left, right;

        public BinarySearchTree(int val) {
            this.val = val;
        }
    }

}
