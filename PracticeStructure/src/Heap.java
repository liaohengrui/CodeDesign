/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/12/25
 */
public class Heap {
    public static void main(String[] args) {
        int[] tree = buildMinHeap(new int[]{9, 3, 7, 6, 5, 1, 10, 2});
        tree = insert(tree, 0);
        tree=poll(tree);
        tree=poll(tree);
        poll(tree);

    }

    //建立大顶堆
    public static int[] buildMinHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustDown(i, array);
        }
        return array;
    }

    public static int[] insert(int[] a, int num) {
        int[] b = new int[a.length + 1];
        int i, j;
        i = 0;
        j = 0;
        while (i < a.length) {
            b[j++] = a[i++];
        }
        b[a.length] = num;
        adjustUp(b, a.length);
        return b;
    }

    public static int[] poll(int[] a) {
        int[] b = new int[a.length - 1];
        b[0] = a[a.length - 1];
        for (int i = 1; i < a.length - 1; i++) {
            b[i] = a[i];
        }
        adjustDown(0,b);
        return b;
    }

    private static void adjustDown(int index, int[] array) {
        if (index * 2 + 1 < array.length) {
            int temp = array[index];
            int j = index * 2 + 1;
            //默认在左边,寻找子节点中最小值
            if (j < array.length - 1 && array[j] > array[j + 1]) {
                j++;
            }
            if (array[index] > array[j]) {
                array[index] = array[j];
                array[j] = temp;
                adjustDown(j, array);
            }
        }
    }

    private static void adjustUp(int[] a, int i) {
        int temp, j;
        temp = a[i];
        j = (i - 1) / 2;
        if (j >= 0 && temp < a[j]) {
            a[i] = a[j];
            a[j] = temp;
            adjustUp(a, j);
        }
    }

    class Node {
        int val;
        Node leftNode;
        Node rightNode;

        public Node(int val) {
            this.val = val;
        }
    }
}
