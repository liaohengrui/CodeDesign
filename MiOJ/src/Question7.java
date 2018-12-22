import java.util.Set;
import java.util.TreeSet;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/22
 */
public class Question7 {
    public static void main(String[] args) {
        String s = solution("-2");
        System.out.println(s);
    }

    private static String solution(String line) {
        String[] strings = line.split(",");
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < strings.length; i++) {
            set.add( Integer.valueOf(strings[i]));
        }
        int i = 0;
        try {
            i = set.ceiling(0);
        } catch (Exception e) {
            return "1";
        }

        while (true) {
            if (set.contains(i)) {
                i++;
            } else {
                return String.valueOf(i);
            }
        }
    }
}
