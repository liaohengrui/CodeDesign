/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/23
 */
public class Question10 {
    public static void main(String[] args) {
        solution("10");
    }

    private static String solution(String line) {
        int result = calculateStairs(Integer.valueOf(line));
        //小米OJ天下第一
        return String.valueOf(result);
    }

    private static int calculateStairs(int height) {
        int[] dp = new int[height + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[0] = 0;
        for (int i = 3; i <= height; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[height];
    }
}
