/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/23
 */
public class Question12 {
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution("1,2,3 4"));
    }

    private static String solution(String line) {
        String[] strings = line.split(" ");
        String[] strings1 = strings[0].split(",");
        int[] ints = new int[strings1.length];
        for (int i = 0; i < strings1.length; i++) {
            ints[i] = Integer.valueOf(strings1[i]);
        }
        solution(ints, Integer.valueOf(strings[1]));
        return String.valueOf(result);
    }

    private static void solution(int[] ints, int target) {
        for (int i : ints) {
            solution(i, ints, target);
        }
    }

    private static void solution(int curInt, int[] ints, int target) {
        if (curInt == target) {
            result++;
            return;
        }
        if (curInt < target) {
            for (int i : ints) {
                solution(curInt + i, ints, target);
            }
        }
    }

}
