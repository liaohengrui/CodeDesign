import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/25
 */
public class ArrayTree {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7};
    public static List<Node> list = new ArrayList<Node>();

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            list.add(node);
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size() / 2 - 1; i++) {
                list.get(i).leftNode = list.get(2 * i + 1);
                list.get(i).rightNode = list.get(2 * i + 2);
            }
        }
        int lastIndex = list.size() / 2 - 1;
        list.get(lastIndex).leftNode = list.get(lastIndex * 2 + 1);
        if (lastIndex * 2 + 2 == list.size() - 1) {
            list.get(lastIndex).rightNode = list.get(lastIndex * 2 + 2);
        }

    }
}

class Node {
    public int val;
    public Node leftNode;
    public Node rightNode;

    public Node(int val) {
        this.val = val;
    }
}
