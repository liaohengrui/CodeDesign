package com.example.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/5
 */
public class CompleteSquare {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> assistQueue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int step = 0;

    public int numSquares(int n) {
        queue.offer(n);
        while (!queue.isEmpty()) {
            int root = queue.poll();
            if (root == 0) {
                return step;
            }
            subSquareNum(assistQueue, root);
            if (queue.isEmpty()) {
                step++;
                queue = assistQueue;
                assistQueue = new LinkedList<>();
            }
        }
        return -1;
    }

    private void subSquareNum(Queue<Integer> assistQueue, int root) {
        int square = 1;
        while (true) {
            int subNum = root - square * square;
            if (subNum < 0) {
                break;
            }
            if (set.add(subNum)) {
                assistQueue.offer(subNum);
            }
            square++;
        }
    }


}

