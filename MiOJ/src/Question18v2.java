import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/25
 */
public class Question18v2 {
    public static void main(String[] args) {
        System.out.println(solution("4 5 0 5 1 2 3 3 0"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        List<People> list = new ArrayList<>();
        for (int i = 1; i < strings.length; i++) {
            People people = new People(Integer.valueOf(strings[i]), Integer.valueOf(strings[++i]));
            list.add(people);
        }
        Collections.sort(list);
        People[] peoples = solution(list);
        StringBuffer buffer = new StringBuffer();
        for (People people : peoples) {
            buffer.append(people.high);
            buffer.append(" ");
            buffer.append(people.position);
            buffer.append(" ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();

    }

    private static People[] solution(List<People> list) {
        People[] peoples = new People[list.size()];
        for (People people : list) {
            int tempIndex = people.position;
            while (true) {
                if (peoples[tempIndex] == null) {
                    if (isCanAdd(peoples, tempIndex, people)) {
                        peoples[tempIndex] = people;
                        break;
                    }
                    tempIndex++;
                } else {
                    tempIndex++;
                }
            }
        }
        return peoples;
    }

    private static boolean isCanAdd(People[] peoples, int tempIndex, People people) {
        int judge = 0;
        for (int i = 0; i < tempIndex; i++) {
            if (peoples[i] == null) {
                judge++;
            } else {
                if (peoples[i].high >= people.high) {
                    judge++;
                }
            }
        }
        if (judge == people.position) {
            return true;
        }
        return false;
    }


    static class People implements Comparable<People> {
        int high;
        int position;

        public People(int high, int position) {
            this.high = high;
            this.position = position;
        }

        @Override
        public int compareTo(People o) {
            if (this.high - o.high != 0) {
                return this.high - o.high;
            }
            return this.position - o.position;
        }
    }
}
