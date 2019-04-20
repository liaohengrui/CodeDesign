package three_month_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/3
 */
public class RootPlant {
    static int counter = 0;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int overall = m * n + 1;
        visited = new int[overall];
        HashMap<Integer, List<Integer>> aroundPoints = new HashMap<>();
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            if (aroundPoints.containsKey(m)) {
                aroundPoints.get(m).add(n);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                aroundPoints.put(m, list);
            }

            int tempM = n;
            int tmpN = m;
            if (aroundPoints.containsKey(tempM)) {
                aroundPoints.get(tempM).add(tmpN);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(tmpN);
                aroundPoints.put(tempM, list);
            }
        }

        for (int i = 0; i < overall; i++) {
            if (visited[i] == 0) {
                counter++;
            }
            dfsRoot(i, aroundPoints);
        }
        System.out.println(--counter);

    }


    private static void dfsRoot(int start, HashMap<Integer, List<Integer>> aroundPoints) {
        visited[start] = 1;
        List<Integer> aroundPoint = aroundPoints.get(start);
        if (checkEnd(aroundPoint)) {
            return;
        }
        for (int i : aroundPoint) {
            if (visited[i] == 0) {
                dfsRoot(i, aroundPoints);
            }
        }
    }

    private static boolean checkEnd(List<Integer> aroundPoint) {
        if (aroundPoint == null) {
            return true;
        }
        for (int i : aroundPoint) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
