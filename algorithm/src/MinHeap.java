import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/18
 */
public class MinHeap {
    private List<Integer> minHeap;

    public MinHeap(List<Integer> minHeap) {
        this.minHeap = minHeap;
        for (int i = (minHeap.size()) / 2 - 1; i >= 0; i--) {
            buildMinHeap(i);
        }
    }

    public int popUpValue() {
        int result = minHeap.get(0);
        minHeap.set(0, minHeap.get(minHeap.size() - 1));
        buildMinHeap(0);
        return result;
    }

    public void insertValue(int value) {
        minHeap.add(value);
        int superNode = minHeap.size() % 2 == 0 ? minHeap.size() / 2 - 1 : (minHeap.size() - 1) / 2 - 1;
        for (; superNode >= 0; ) {
            buildMinHeap(superNode);
            superNode = superNode % 2 == 0 ? superNode / 2 - 1 : (superNode - 1) / 2;
        }
    }

    private void buildMinHeap(int middle) {
        int l = getLeft(middle);
        int r = getRight(middle);
        int minPosition = middle;
        if (l < minHeap.size() && minHeap.get(l) < minHeap.get(minPosition)) {
            minPosition = l;
        }
        if (r < minHeap.size() && minHeap.get(r) < minHeap.get(minPosition)) {
            minPosition = r;
        }
        if (minPosition == middle) {
            return;
        }
        swap(middle, minPosition);
        buildMinHeap(minPosition);
    }

    private void swap(int original, int minPosition) {
        int temp = minHeap.get(original);
        minHeap.set(original, minHeap.get(minPosition));
        minHeap.set(minPosition, temp);
    }

    private int getRight(int middle) {
        return (middle + 1) << 1;
    }

    private int getLeft(int middle) {
        return (middle << 1) + 1;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MinHeap minHeap = new MinHeap(new ArrayList<>(Arrays.asList(ints)));
        System.out.println(minHeap.minHeap);
        minHeap.insertValue(91);
        minHeap.insertValue(72);
        minHeap.insertValue(49);
        minHeap.insertValue(9);

    }
}
