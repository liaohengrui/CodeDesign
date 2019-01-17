package com.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class Kruskal {
    int[][] graph = BaseGraph.getMatrixValueGraph();
    AndCheck andCheck = new AndCheck();

    public String kruskalMinTree(int[][] graph) {
        StringBuffer buffer = new StringBuffer();
        for (int z = 0; z < graph.length - 1; z++) {
            int min = 10000;
            int v1 = -1;
            int v2 = -1;
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] < min) {
                        if (!andCheck.checkUnion(i, j)) {
                            v1 = i;
                            v2 = j;
                            min = graph[i][j];
                        }
                    }
                }
            }
            andCheck.join(v1, v2);
            buffer.append(v1 + "-->" + v2);
            buffer.append("\r\n");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        String s = kruskal.kruskalMinTree(kruskal.graph);
        System.out.println(s);
    }
}
