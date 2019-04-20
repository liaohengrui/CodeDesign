package winter.first_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;


@SuppressWarnings("ALL")
public class Solution {
    int[] arr;
    Random random;


    public static void main(String[] args) {


        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
        solution.shuffle();

        // 重设数组到它的初始状态[1,2,3]。
        solution.reset();

        // 随机返回数组[1,2,3]打乱后的结果。
        solution.shuffle();
    }

    public Solution(int[] nums) {
        arr = nums;
        random = new Random();

    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int[] shuffleArr = new int[arr.length];
        for (int i = shuffleArr.length; i > 0; i--) {
            int index = random.nextInt(i);
            shuffleArr[i - 1] = list.get(index);
            list.remove(index);
        }
        return shuffleArr;
    }
}