package three_month_1;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class DFSLattices {
    static int counter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] lattices = new int[2][len];
        int[][] visited = new int[2][len];
        int[] start = new int[]{0, 0};
        dfsPlaid(lattices, start, visited);
        System.out.println(counter);


    }

    private static void dfsPlaid(int[][] lattices, int[] start, int[][] visited) {
        int x = start[0];
        int y = start[1];
        visited[x][y] = 1;
        if (checkVisited(visited)) {
            counter++;
            visited[x][y] = 0;
            return;
        }
        List<int[]> aroundPoint = canVisited(start, visited, lattices[0].length);
        int aroundNum = aroundPoint.size();
        dfsPlaid(lattices, aroundPoint.get(0), visited);
        visited[x][y] = 0;
        counter *= aroundNum;
        counter = counter % 1000000007;

    }

    private static boolean checkVisited(int[][] visited) {
        for (int[] rowVisited : visited) {
            for (int i : rowVisited) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<int[]> canVisited(int[] start, int[][] visited, int len) {
        List<int[]> result = new ArrayList<>();
        int x = start[0];
        int y = start[1];
        //左边
        if (y - 1 >= 0 && visited[x][y - 1] == 0) {
            result.add(new int[]{x, y - 1});
        }
        //右边
        if (y + 1 < len && visited[x][y + 1] == 0) {
            result.add(new int[]{x, y + 1});
        }
        //上边
        if (x - 1 == 0 && visited[x - 1][y] == 0) {
            result.add(new int[]{x - 1, y});
        }
        //下边
        if (x + 1 == 1 && visited[x + 1][y] == 0) {
            result.add(new int[]{x + 1, y});
        }
        //左上边
        if (y - 1 >= 0 && x - 1 == 0 && visited[x - 1][y - 1] == 0) {
            result.add(new int[]{x - 1, y - 1});
        }
        //左下边
        if (y - 1 >= 0 && x + 1 == 1 && visited[x + 1][y - 1] == 0) {
            result.add(new int[]{x + 1, y - 1});
        }
        //右上边
        if (y + 1 < len && x - 1 == 0 && visited[x - 1][y + 1] == 0) {
            result.add(new int[]{x - 1, y + 1});
        }
        //右下边
        if (y + 1 < len && x + 1 == 1 && visited[x + 1][y + 1] == 0) {
            result.add(new int[]{x + 1, y + 1});
        }
        return result;
    }
}
