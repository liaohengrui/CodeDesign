package arithmetic;



import java.util.Scanner;
import java.util.function.DoublePredicate;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/6
 */
public class UnnamedLate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = dpBorrow(m, n);
        System.out.print(result);
    }

    /**
     * m还鞋子
     * n借鞋子
     */
    private static int dpBorrow(int m, int n) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (m == n) {
            return dpBorrow(m, n - 1);
        }
        return dpBorrow(m - 1, n) + dpBorrow(m, n - 1);
    }
}
