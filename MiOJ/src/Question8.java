import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/22
 */
public class Question8 {
    static int result = 0;



    private static String solution(String line) {
        String[] strings = line.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : strings) {
            list.add(Integer.valueOf(s));
        }
        doChange(list);
        return String.valueOf(result);
    }

    private static void doChange(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            Integer temp = list.get(i);
            for (int j = i - 1; j >= -1; j--) {
                if (j == -1 || temp > list.get(j)) {
                    list.remove(temp);
                    list.add(j + 1, temp);
                    break;
                }
                result++;
            }
        }
    }
}
