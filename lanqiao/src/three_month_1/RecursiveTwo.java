package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class RecursiveTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(recursive(k, n));
    }

    private static int recursive(int k, int n) {
        if (k == 0 || k == n) {
            return 1;
        }
        return recursive(k, n - 1) + recursive(k - 1, n - 1);
    }
}
