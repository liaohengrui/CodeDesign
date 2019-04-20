package three_month_2;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/3
 */
public class WeightJudge {
    static int[] weights;
    static int[] values;
    static int[] remains;
    static int value;
    static boolean flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        weights = new int[n];
        values = new int[m];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        remains = new int[n + 1];
        remainWeight();

        for (int i = 0; i < m; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value = values[i];
            flag = false;
            dfs(0, 0);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static void dfs(int num, int sum) {
        if (sum == value) {
            flag = true;
            return;
        }
        if (num >= weights.length || flag) {
            return;
        }
        int remain = remains[num];
        if (remain < value - sum) {
            return;
        }
        dfs(num + 1, sum + weights[num]);
        dfs(num + 1, sum);
        dfs(num + 1, sum - weights[num]);
    }

    private static void remainWeight() {
        for (int i = weights.length - 1; i >= 0; i--) {
            remains[i] = remains[i + 1] + weights[i];
        }
    }
}
