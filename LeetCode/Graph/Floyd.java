package com.example.graph;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class Floyd {


    public int[][] floydGraph(int[][] graph) {
        int[][] valuePath = graph.clone();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (j != k) {
                        if (valuePath[j][i] + valuePath[i][k] < valuePath[j][k]) {
                            valuePath[j][k] = valuePath[j][i] + valuePath[i][k];
                        }
                    }
                }
            }
        }
        return valuePath;
    }

    public static void main(String[] args) {
        Floyd floyd = new Floyd();
        int[][] graph = BaseGraph.getFloydGraph();
        floyd.floydGraph(graph);
    }
}
