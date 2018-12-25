/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/24
 */
public class Question14 {
    public static void main(String[] args) {
        System.out.println(solution("4,5,6,7,0,1,2 6"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        String[] strings1 = strings[0].split(",");
        for (int i = 0; i < strings1.length; i++) {
            if (strings1[i].equals(strings[1])) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }
}
