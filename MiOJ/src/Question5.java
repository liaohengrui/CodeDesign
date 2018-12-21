/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/21
 */
public class Question5 {
    private static String solution(String line) {
        String[] strings = line.split(",");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.valueOf(strings[i]);
        }
        int left = 0;
        int right = ints.length - 1;
        while (right - left >= 1) {
            int middle = left + (right - left) / 2;
            if (ints[middle] > ints[middle + 1]) {
                ints = createInts(ints, middle + 1);
                return String.valueOf(ints[ints.length / 2]);
            } else {
                if (ints[middle] < ints[left]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
        }
        return String.valueOf(ints[ints.length / 2]);
    }

    private static int[] createInts(int[] original, int middle) {
        int judge = middle - 1;
        int[] ints = new int[original.length];
        int index = 0;
        while (middle != judge) {
            ints[index] = original[middle];
            middle++;
            index++;
            if (middle == original.length) {
                middle = 0;
            }
        }
        ints[index] = original[judge];
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(solution("4,5,6,7,0,1,2"));
    }
}
