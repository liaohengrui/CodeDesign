package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class Walnuts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int result = minNum(a, b, c);
        System.out.println(result);
    }

    private static int minNum(int a, int b, int c) {
        int min = Math.max(a, b > c ? b : c);
        for (int i = min; i < Integer.MAX_VALUE; i++) {
            if (i % a == 0 && i % b == 0 && i % c == 0) {
                return i;
            }
        }
        return -1;
    }
}
