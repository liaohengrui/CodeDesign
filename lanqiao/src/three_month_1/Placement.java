package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class Placement {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        dp = new int[n+1];
        System.out.println(solution(n));

    }

    private static int solution(int placementNum) {
        if (placementNum < 0) {
            return 0;
        }
        if (placementNum == 1) {
            return 1;
        }
        if (placementNum == 2) {
            return 2;
        }

        int i1 = -1;
        int i2 = -1;
        if (dp[placementNum - 1] != 0) {
            i1 = dp[placementNum - 1];
        } else {
            i1 = solution(placementNum - 1);
        }
        if (dp[placementNum - 2] != 0) {
            i2 = dp[placementNum - 2];
        } else {
            i2 = solution(placementNum - 2);
        }

        dp[placementNum] = i1 + i2;
        return dp[placementNum];

    }
}
