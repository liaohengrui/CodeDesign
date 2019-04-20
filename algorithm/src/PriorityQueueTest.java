import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/17
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();

        queue = new PriorityQueue<>((i1, i2) -> {
            return (int) (i2 - i1);
        });
        for (int i = 0; i < 10; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            Integer in = queue.poll();
            System.out.println("Processing Integer:" + in);
        }
    }
}
