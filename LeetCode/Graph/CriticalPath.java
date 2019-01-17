package com.example.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/17
 */
public class CriticalPath {
    public List<Integer> criticalPath(int[][] graph) {
        int[] ve = new int[graph.length];
        int[] vl = new int[graph.length];
        int[] indegree = Topological.findInDegree(graph);
        ve[0] = 0;

        Stack<Integer> integerStack = new Stack<>();
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                integerStack.push(i);
            }
            vl[i] = 10000;
        }
        while (!integerStack.isEmpty()) {
            int i = integerStack.pop();
            count++;
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    indegree[j] -= 1;
                    if (indegree[j] == 0) {
                        //最早开始时间
                        for (int k = 0; k < graph.length; k++) {
                            if (graph[k][j] != 0) {
                                if (ve[j] < ve[k] + graph[k][j]) {
                                    ve[j] = ve[k] + graph[k][j];
                                }
                            }
                        }
                        integerStack.push(j);
                    }
                }
            }
        }
        if (count < graph.length) {
            return null;
        }
        vl[graph.length - 1] = ve[graph.length - 1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    if (vl[i] > ve[j] - graph[i][j]) {
                        vl[i] = ve[j] - graph[i][j];
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (ve[i] == vl[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        CriticalPath criticalPath = new CriticalPath();
        int[][] graph = BaseGraph.getCriticalGraph();
        System.out.println(criticalPath.criticalPath(graph));
        ;
    }

}
