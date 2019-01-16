package com.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class Prime {
    int[][] graph = BaseGraph.getMatrixValueGraph();

    public List<Integer> primeCreateMinTree(int[][] graph) {
        List<Integer> vertexList = new ArrayList<>();
        //设置起点为0
        vertexList.add(0);
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        for (int z = 0; z < graph.length - 1; z++) {
            int min = 10000;
            int index = -1;
            for (int vertex : vertexList) {
                for (int i = 0; i < graph.length; i++) {
                    if (!visited[i] && graph[vertex][i] < min) {
                        min = graph[vertex][i];
                        index = i;
                    }
                }
            }
            visited[index] = true;
            vertexList.add(index);
        }
        return vertexList;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        List<Integer> list = prime.primeCreateMinTree(prime.graph);
        System.out.println(list);
    }
}
