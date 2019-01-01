import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/1
 */
public class Question20 {
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution("90 85 -32 61 29 -85 4 -44 21 97 -100 87 59 3 -38 -85 2 29 26 -37 -61 -100 -37"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        List<Integer> list = new ArrayList<>();
        Set set = new HashSet();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.valueOf(strings[i]));
            set.add(strings[i]);
        }
        solution(list);
        if (set.size() == 1) {
            result++;
        }
        return String.valueOf(result);
    }

    private static void solution(List<Integer> nums) {
        int[][] dp = new int[nums.size()][nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int sub = nums.get(j) - nums.get(i);
                int x = nums.get(i) - sub;
                List<Integer> indexs = findIndex(nums, x, i);
                if (!indexs.isEmpty()) {
                    dp[i][j] = 1;
                    for (int index : indexs) {
                        dp[i][j] += dp[index][i];
                    }
                } else {
                    dp[i][j] = 1;
                }
                result += dp[i][j];
            }
        }

    }

    private static List<Integer> findIndex(List<Integer> nums, int target, int currentIndex) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (i < currentIndex && nums.get(i) == target) {
                indexs.add(i);
            }
        }
        return indexs;
    }
}
