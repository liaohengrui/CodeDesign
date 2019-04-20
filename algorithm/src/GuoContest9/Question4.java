package GuoContest9;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/20
 */
public class Question4 {
    static int N;
    static int K;

    static int[] dp;

    private static int calculateMaxStep(int n) {
        if (n >= K) {
            if (dp[n - K] == -1) {
                dp[n - K] = calculateMaxStep(n - K);
            }
            if (dp[n - 1] == -1) {
                dp[n - 1] = calculateMaxStep(n - 1);
            }
            dp[n] = Math.min(dp[n - K], dp[n - 1]) + 1;
        } else {
            if (dp[n - 1] == -1) {
                dp[n - 1] = calculateMaxStep(n - 1);
            }
            dp[n] = dp[n - 1] + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        N = 5;
        K = 3;
        dp = new int[N];
        //默认0起步
        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        calculateMaxStep(4);
        System.out.println(dp);
    }
}
