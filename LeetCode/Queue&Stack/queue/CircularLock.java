package com.example.demo;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/3
 */
public class CircularLock {
    Queue<String> queue;
    Set<String> set;
    int step = 0;
    Queue<String> assistQueue;
    Set<String> dead;

    public CircularLock() {
        queue = new LinkedList();
        set = new HashSet();
        assistQueue = new LinkedList<>();
    }


    public int openLock(String[] deadends, String target) {
        queue.add("0000");
        dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        while (!queue.isEmpty()) {
            String root = queue.poll();
            if (target.equals(root)) {
                return step;
            }
            bfsRoot(root, assistQueue, deadends);
            if (queue.isEmpty()) {
                queue = assistQueue;
                assistQueue = new LinkedList<>();
                step++;
            }
        }
        return -1;
    }

    private void bfsRoot(String root, Queue<String> assistQueue, String[] deadends) {
        for (int i = 0; i < 4; i++) {
            char c = root.charAt(i);
            StringBuffer addBuffer = new StringBuffer(root);
            StringBuffer subBuffer = new StringBuffer(root);
            addBuffer.setCharAt(i, change(c, 1));
            subBuffer.setCharAt(i, change(c, -1));
            String temp = addBuffer.toString();
            if (!dead.contains(temp) && set.add(temp)) {
                assistQueue.add(temp);
            }
            temp = subBuffer.toString();
            if (!dead.contains(temp) && set.add(temp)) {
                assistQueue.add(temp);
            }
        }
    }

    private char change(char c, int i) {
        if (1 == i) {
            return c == '9' ? '0' : (char) (c + i);
        } else {
            return c == '0' ? '9' : (char) (c + i);
        }
    }


    public static void main(String[] args) {

        CircularLock lock = new CircularLock();
        int i = lock.openLock(new String[]{"8888"}, "0009");
        System.out.println(i);

    }


}
