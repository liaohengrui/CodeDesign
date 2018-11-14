package com.example.array;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/14
 */
public class SpiralMatrix {
    int col;
    int row;
    int m = 0;
    int n = 0;
    int k = 1;
    Set<Integer> set = new HashSet();
    //顺时针上右下左
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            Integer[] integers = {};
            return Arrays.asList(integers);
        }
        if (matrix.length == 1) {
            List list = new ArrayList();
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }

        if (matrix[0].length == 1) {
            List list = new ArrayList();
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        col = matrix[0].length;
        row = matrix.length;
        this.matrix = matrix;
        Integer[] ints = new Integer[col * row];
        set.add(matrix[0][0]);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = matrix[m][n];
            move();
        }
        return Arrays.asList(ints);
    }

    private void move() {
        //上移过界
        if (m + direction[k][0] < 0) {
            k++;
            m += direction[k][0];
            n += direction[k][1];
            set.add(matrix[m][n]);
            return;
        } else if (n + direction[k][1] >= col) {
            //右移过界
            k++;
            m += direction[k][0];
            n += direction[k][1];
            set.add(matrix[m][n]);
            return;
        } else if (m + direction[k][0] >= row) {
            //下移过界
            k++;
            m += direction[k][0];
            n += direction[k][1];
            set.add(matrix[m][n]);
            return;
        } else if (n + direction[k][1] < 0) {
            //左移过界
            k = 0;
            m += direction[k][0];
            n += direction[k][1];
            set.add(matrix[m][n]);
            return;
        }

        if (set.add(matrix[m + direction[k][0]][n + direction[k][1]])) {
            m += direction[k][0];
            n += direction[k][1];
        } else {
            k++;
            if (k >= 4) {
                k = 0;
            }
            m += direction[k][0];
            n += direction[k][1];
            set.add(matrix[m][n]);
        }
    }

    public static void main(String[] args) {
        new SpiralMatrix().spiralOrder(new int[][]{{3},{2}});
    }
}
