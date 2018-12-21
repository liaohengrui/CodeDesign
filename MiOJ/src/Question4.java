import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/21
 */
public class Question4 {
    private static String solution(String line) {
        Set<Integer> set = new HashSet<>();
        String[] strings = line.split(",");
        for (String s : strings) {
            set.add(Integer.valueOf(s));
        }
        int size = -1;
        for (int i = 0; i < strings.length; i++) {
            int num = Integer.valueOf(strings[i]);
            int upNum = num;
            int downNum = num;
            int tempSize = -1;
            if (set.contains(num)) {
                set.remove(num);
                tempSize+=2;
                //上边界
                while (set.contains(++upNum)) {
                    tempSize++;
                    set.remove(upNum);
                }
                //下边界
                while (set.contains(--downNum)) {
                    tempSize++;
                    set.remove(downNum);
                }
                if (tempSize > size) {
                    size = tempSize;
                }
            }
        }
        return String.valueOf(size);
    }


}
