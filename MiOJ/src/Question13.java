import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/24
 */
public class Question13 {
    public static void main(String[] args) {
        System.out.println(solution("1,1,3,3,2,2 2"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        return solution(strings[0].replaceAll(",", "").toCharArray(), Integer.valueOf(strings[1]));
    }

    private static String solution(char[] chars, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                int i = map.get(c);
                map.put(c, i + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o2.getValue() - o1.getValue() != 0) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });
        for (Map.Entry entry : map.entrySet()) {
            queue.offer(entry);
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < k; i++) {
            buffer.append(queue.poll().getKey());
            buffer.append(',');
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
}
