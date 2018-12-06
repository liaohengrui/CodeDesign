package arithmetic;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/6
 */
public class legend {
    static List<Queue> cantPut = new ArrayList<>();
    static List<Queue> queueList = new ArrayList<>();
    static int n;
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int kingX = scanner.nextInt() - 1;
        int kingY = scanner.nextInt() - 1;
        for (int i = kingX - 1; i <= kingX + 1; i++) {
            for (int j = kingY - 1; j <= kingY + 1; j++) {
                if (i < 0 || j < 0) {
                    continue;
                }
                if (i >= n || j >= n) {
                    continue;
                }
                cantPut.add(new Queue(i, j));
            }
        }
        putQueue(0);
        System.out.print(result);
    }

    private static void putQueue(int row) {
        if (row == n) {
            result++;
        }

        for (int j = 0; j < n; j++) {
            if (isCanSet(row, j)) {
                Queue queue = new Queue(row, j);
                queueList.add(queue);
                putQueue(row + 1);
                queueList.remove(queue);
            }
        }

    }


    private static boolean isCanSet(int x, int y) {
        for (Queue queue : cantPut) {
            if (queue.x == x && queue.y == y) {
                return false;
            }
        }
        for (Queue queue : queueList) {
            if (queue.x == x) {
                return false;
            }
            if (queue.y == y) {
                return false;
            }
            if (Math.abs(queue.y - y) == Math.abs(queue.x - x)) {
                return false;
            }
        }
        return true;
    }


    static class Queue {
        int x;
        int y;

        public Queue(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
