package arithmetic;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/6
 */
public class CharIegend {
    private static int count = 0;
    private static int n;
    private static int kingX;
    private static int kingY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        kingX = scanner.nextInt() - 1;
        kingY = scanner.nextInt() - 1;
        int[][] chess = new int[n][n];
        putQueenAtRow(chess, 0);
        System.out.print(count);
    }

    private static void putQueenAtRow(int[][] chess, int row) {
        /**
         * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后
         * 输出结果，终止递归
         */
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isAroundKing(row, i)) {
                if (isSafety(chess, row, i)) {
                    chess[row][i] = 1;
                    putQueenAtRow(chess, row + 1);
                    chess[row][i] = 0;
                }
            }
        }
    }


    private static boolean isSafety(int[][] chess, int row, int col) {
        //判断中上、左上、右上是否安全
        int step = 1;
        while (row - step >= 0) {
            if (chess[row - step][col] == 1) {
                return false;
            }
            if (col - step >= 0 && chess[row - step][col - step] == 1) {
                return false;
            }
            if (col + step < n && chess[row - step][col + step] == 1) {
                return false;
            }
            step++;
        }
        return true;
    }

    private static boolean isAroundKing(int x, int y) {
        if (Math.abs(x - kingX) <= 1 && Math.abs(y - kingY) <= 1) {
            return true;
        }
        return false;
    }
}
