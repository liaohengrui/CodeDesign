/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/22
 */
public class Question9 {
    public static void main(String[] args) {
        System.out.println(solution("1432219 3"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        String s = solution(new StringBuffer(strings[0]), Integer.valueOf(strings[1]));
        StringBuffer buffer = new StringBuffer(s);
        try {
            while (buffer.charAt(0) == '0') {
                buffer.deleteCharAt(0);
            }
        } catch (Exception e) {
            return "0";
        }
        return buffer.toString();
    }

    private static String solution(StringBuffer s, int times) {
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) > s.charAt(j + 1)) {
                    s.deleteCharAt(j);
                    break;
                }
                if (j + 1 == s.length() - 1) {
                    s.deleteCharAt(j + 1);
                }
            }
        }
        return s.toString();
    }
}
