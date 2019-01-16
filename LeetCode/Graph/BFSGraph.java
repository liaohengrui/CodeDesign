package com.example.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class BFSGraph {
    int[][] graph = BaseGraph.getMatrixGraph();
    boolean[] visited = new boolean[graph.length];
    StringBuffer buffer = new StringBuffer();

    public void bfsGraph(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            if (!visited[vertex]) {
                visited[vertex] = true;
                buffer.append(vertex + ",");
                for (int i = 0; i < graph.length; i++) {
                    if (graph[vertex][i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph();
        graph.bfsGraph(0);
        System.out.println(graph.buffer.toString());
    }
}
