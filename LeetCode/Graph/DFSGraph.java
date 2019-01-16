package com.example.graph;

import javafx.scene.shape.Arc;

import java.util.Set;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class DFSGraph {
    int[][] graph = BaseGraph.getMatrixGraph();
    boolean[] visited = new boolean[graph.length];
    StringBuffer buffer = new StringBuffer();
    BaseGraph.ALGraph alGraph = BaseGraph.getALgragh();

    public void dfsMatrixGraph(int vertex) {
        //未被访问过
        if (!visited[vertex]) {
            visited[vertex] = true;
            int[] adjList = graph[vertex];
            buffer.append(vertex + ",");
            for (int adjVertex = 0; adjVertex < adjList.length; adjVertex++) {
                if (adjList[adjVertex] == 1) {
                    dfsMatrixGraph(adjVertex);
                }

            }
        }
    }

    public void dfsAlGrapg(BaseGraph.ALGraph graph, int vertex) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            buffer.append(vertex + ",");
        }
        BaseGraph.ArcNode arcNode = graph.vNodes[vertex].arcNode;
        while (arcNode != null) {
            if (!visited[arcNode.vertex]) {
                visited[arcNode.vertex] = true;
                buffer.append(arcNode.vertex + ",");
                dfsAlGrapg(graph, arcNode.vertex);
                arcNode = arcNode.nextNode;
            } else {
                arcNode = arcNode.nextNode;
            }
        }
    }


}
