/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/20
 */
public class Question3 {
    private static String solution(String line) {
        String[] strings = line.split("-");
        StringBuffer buffer = new StringBuffer();
        StringBuffer max = new StringBuffer(strings[0]).reverse();
        StringBuffer min = new StringBuffer(strings[1]).reverse();
        for (int i = 0; i < max.length(); i++) {
            int sub = 0;
            if (i < min.length()) {
                sub = max.charAt(i) - min.charAt(i);
                if (sub < 0) {
                    max.setCharAt(i + 1, (char) (max.charAt(i + 1) - 1));
                    sub += 10;
                }
            } else {
                sub = max.charAt(i) - 48;
            }
            buffer.insert(0, sub);
        }
        return buffer.toString();
    }


}
