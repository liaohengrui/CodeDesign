package com.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/17
 */
public class Topological {
    public static void main(String[] args) {
        int[][] graph = BaseGraph.getTopologicalGraph();
        Topological topological = new Topological();
        System.out.println(topological.topologicalSort(graph));
    }

    public List<Integer> topologicalSort(int[][] graph) {
        int[] indegree = findInDegree(graph);
        List<Integer> list = new ArrayList<>();
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                integerStack.push(i);
            }
        }
        while (!integerStack.isEmpty()) {
            int i = integerStack.pop();
            list.add(i);
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    indegree[j] -= 1;
                    if (indegree[j] == 0) {
                        integerStack.push(j);
                    }
                }
            }
        }
        if (list.size() < graph.length) {
            return null;
        } else {
            return list;
        }
    }

    public static int[] findInDegree(int[][] graph) {
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[j][i] == 1) {
                    indegree[i] += 1;
                }
            }
        }
        return indegree;
    }

}
