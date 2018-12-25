import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/24
 */
public class Question15 {
    static int result = 0;
    static List<List<Integer>> lists = new ArrayList<>();



    private static String solution(String line) {
        String[] strings = line.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.valueOf(strings[i]));
        }
        searchDST(list, 0, 1);
        return String.valueOf(result);
    }

    private static void searchDST(List<Integer> nums, int num, int height) {
        if (height > 3) {
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer temp = nums.get(i);
            if (num + temp == 0 && height == 3) {
                nums.remove(temp);
                if (lists.isEmpty()) {
                    result++;
                    lists.add(new ArrayList<>(nums));
                } else {
                    boolean flag = true;
                    for (List<Integer> list : lists) {
                        if (someList(list, nums)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        lists.add(new ArrayList<>(nums));
                        result++;
                    }
                }
                nums.add(i, temp);
                continue;
            }
            nums.remove(temp);
            searchDST(nums, num + temp, height + 1);
            nums.add(i, temp);
        }
    }

    private static boolean someList(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
