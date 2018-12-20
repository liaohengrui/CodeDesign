import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/20
 */
public class Question2 {
    private static String solution(String line) {
        String[] strings = line.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
