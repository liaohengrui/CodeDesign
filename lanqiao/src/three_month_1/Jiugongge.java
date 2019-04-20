package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class Jiugongge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ints = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += ints[0][i];
        }

        for (int i = 0; i < 3; i++) {
            int temp1 = result;
            int temp2 = result;
            for (int j = 0; j < 3; j++) {
                temp1 -= ints[i][j];
                temp2 -= ints[j][i];
            }
            if (temp1 != 0 || temp2 != 0) {
                System.out.println(0);
                return;
            }
        }
        //判断对角线
        int temp1 = result;
        int temp2 = result;
        temp1 = temp1 - ints[0][0] - ints[1][1] - ints[2][2];
        temp2 = temp2 - ints[0][2] - ints[1][1] - ints[2][0];
        if (temp1 != 0 || temp2 != 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }


    }
}
