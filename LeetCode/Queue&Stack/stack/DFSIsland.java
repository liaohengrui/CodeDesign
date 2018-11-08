package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/7
 */
public class DFSIsland {
    boolean[][] isVisited;
    int result = 0;
    int row, col;
    char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        //数据校验
        try {
            row = grid.length;
            col = grid[0].length;
        } catch (Exception e) {
            return 0;
        }

        if (grid == null || row == 0 || col == 0) {
            return 0;
        }
        isVisited = new boolean[row][col];
        //i是行数,k是列数
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (!isVisited[i][k] && grid[i][k] == '1') {
                    dfsSearch(i, k);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfsSearch(int i, int k) {
        //没被访问
        if (!isVisited[i][k] && grid[i][k] == '1') {
            isVisited[i][k] = true;
            //判断左移是否合法
            if (k - 1 >= 0) {
                dfsSearch(i, k - 1);
            }
            //判断右移是否合法
            if (k + 1 < col) {
                dfsSearch(i, k + 1);
            }
            //判断上移是否合法
            if (i - 1 >= 0) {
                dfsSearch(i - 1, k);
            }
            //判断下移是否合法
            if (i + 1 < row) {
                dfsSearch(i + 1, k);
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        DFSIsland island = new DFSIsland();
        System.out.println(island.numIslands(chars));

    }
}
