import java.io.PipedReader;
import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/25
 */
public class Question18 {

    static boolean flag = false;
    static int size;

    public static void main(String[] args) {
        System.out.println(solution("6 7 0 4 4 7 1 5 0 6 1 5 2"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        List<people> list = new ArrayList<>();
        for (int i = 1; i < strings.length; i++) {
            people people = new people(Integer.valueOf(strings[i]), Integer.valueOf(strings[++i]));
            list.add(people);
        }
        size = list.size() - 1;
        List<people> peoples = solution(list, new ArrayList<>());
        StringBuffer buffer = new StringBuffer();
        for (people people : peoples) {
            buffer.append(people.high);
            buffer.append(" ");
            buffer.append(people.position);
            buffer.append(" ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    private static List<people> solution(List<people> entryList, List<people> result) {
        for (int i = 0; i < entryList.size(); i++) {
            people entry = entryList.get(i);
            if (canAdd(result, entry)) {
                entryList.remove(i);
                result.add(entry);
                solution(entryList, result);
                if (flag) {
                    return result;
                }
                result.remove(entry);
                entryList.add(i, entry);
            }
        }
        return null;
    }

    private static boolean canAdd(List<people> result, people entry) {
        int i = 0;
        for (people one : result) {
            if (one.high >= entry.high) {
                i++;
            }
        }
        if (i == entry.position) {
            if (result.size() == size) {
                flag = true;
            }
            return true;
        }
        return (result.isEmpty() && entry.position == 0) ? true : false;
    }

    static class people {
        int high;
        int position;

        public people(int high, int position) {
            this.high = high;
            this.position = position;
        }
    }
}
