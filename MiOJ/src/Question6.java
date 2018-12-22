import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/21
 */
public class Question6 {
    public static void main(String[] args) {
        int a = 1;
        double b = 1.1;
        double c = a + b;
        System.out.println(c);
    }

    private static String solution(String line) {
        String[] strings = line.split(",");
        boolean b = isInterleave(strings[0], strings[1], strings[2]);
        return String.valueOf(b);
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        if (s1.length() == 0)
            return s2 == s3;
        if (s2.length() == 0)
            return s1 == s3;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        //初始化dp
        dp[0][0] = 1;
        for (int i = 1; i < s1.length() + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < s2.length() + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = 1;
            }
        }
        //dp
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                int t = i + j;
                if (t - 1 == 9) {
                    System.out.println("-");
                }
                if (s1.charAt(i - 1) == s3.charAt(t - 1)) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (s2.charAt(j - 1) == s3.charAt(t - 1)) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        if (dp[s1.length()][s2.length()] == 1) {
            return true;
        }
        return false;
    }
}
