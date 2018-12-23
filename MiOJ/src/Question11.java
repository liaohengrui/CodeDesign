import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/23
 */
public class Question11 {
    public static void main(String[] args) {
        System.out.println(solution("a b"));
    }

    private static String solution(String line) {
        return solution(line.split(" ")[0], line.split(" ")[1]);
    }

    private static String solution(String shortStr, String longStr) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : longStr.toCharArray()) {
            if (map.containsKey(c)) {
                Integer i = map.get(c);
                map.put(c, i + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : shortStr.toCharArray()) {
            if (map.containsKey(c)) {
                Integer i = map.get(c);
                if (i > 0) {
                    map.put(c, i - 1);
                } else {
                    return "false";
                }
            }else {
                return "false";
            }
        }
        return "true";
    }
}
