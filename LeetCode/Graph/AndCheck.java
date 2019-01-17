package com.example.graph;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class AndCheck {
    int[] pre = new int[1000];

    public AndCheck() {
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
    }

    //查找根结点
    int unionsearch(int root) {
        int son, tmp;
        son = root;
        //寻找根结点
        while (root != pre[root]) {
            root = pre[root];
        }
        //路径压缩
        while (son != root) {
            tmp = pre[son];
            pre[son] = root;
            son = tmp;
        }
        return root;
    }


    boolean checkUnion(int root1, int root2) {
        int x, y;
        x = unionsearch(root1);
        y = unionsearch(root2);
        return x == y;
    }

    //判断是否连通，不连通就合并
    void join(int root1, int root2) {
        int x, y;
        x = unionsearch(root1);
        y = unionsearch(root2);
        //如果不连通，就把它们所在的连通分支合并
        if (x != y) {
            pre[x] = y;
        }
    }


}
