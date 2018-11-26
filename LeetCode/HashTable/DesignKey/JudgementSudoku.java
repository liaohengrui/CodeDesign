package com.example.DesignKey;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/24
 */
public class JudgementSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!judgeRow(board)) {
            return false;
        }
        if (!judgeCol(board)) {
            return false;
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!judgeSudoku(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean judgeSudoku(int row, int col, char[][] board) {
        Set set = new HashSet();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j]=='.') {
                    continue;
                }
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean judgeCol(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!set.add(board[j][i])) {
                    return false;
                }
            }
            set.clear();
        }
        return true;
    }

    private boolean judgeRow(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
            set.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        JudgementSudoku judgementSudoku = new JudgementSudoku();
        char[][] board = new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},

                };
        boolean b = judgementSudoku.isValidSudoku(board);
        System.out.println(b);
    }
}
