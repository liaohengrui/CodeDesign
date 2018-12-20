/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/20
 */
public class Question1 {
    private static String solution(String line) {
        String[] strings = line.split(" ");
        return String.valueOf(Integer.valueOf(strings[0]) + Integer.valueOf(strings[1]));
    }
}
