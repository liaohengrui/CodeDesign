package com.example.graph;

import javafx.scene.shape.Arc;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/1/16
 */
public class BaseGraph {
    static int[][] graph = new int[8][8];

    static int[][] getMatrixGraph() {
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][3] = 1;
        graph[1][4] = 1;
        graph[1][0] = 1;
        graph[2][0] = 1;
        graph[2][5] = 1;
        graph[2][6] = 1;
        graph[3][1] = 1;
        graph[3][7] = 1;
        graph[4][1] = 1;
        graph[4][7] = 1;
        graph[5][2] = 1;
        graph[5][6] = 1;
        graph[6][2] = 1;
        graph[6][5] = 1;
        graph[7][3] = 1;
        graph[7][4] = 1;
        return graph;
    }

    static ALGraph getALgragh() {
        ALGraph alGraph = new ALGraph();
        alGraph.vNodes[0] = new VNode();
        alGraph.vNodes[0].arcNode = new ArcNode(1);
        alGraph.vNodes[0].arcNode.nextNode = new ArcNode(2);

        alGraph.vNodes[1] = new VNode();
        alGraph.vNodes[1].arcNode = new ArcNode(0);
        alGraph.vNodes[1].arcNode.nextNode = new ArcNode(3);
        alGraph.vNodes[1].arcNode.nextNode.nextNode = new ArcNode(4);

        alGraph.vNodes[2] = new VNode();
        alGraph.vNodes[2].arcNode = new ArcNode(0);
        alGraph.vNodes[2].arcNode.nextNode = new ArcNode(5);
        alGraph.vNodes[2].arcNode.nextNode.nextNode = new ArcNode(6);

        alGraph.vNodes[3] = new VNode();
        alGraph.vNodes[3].arcNode = new ArcNode(1);
        alGraph.vNodes[3].arcNode.nextNode = new ArcNode(7);

        alGraph.vNodes[4] = new VNode();
        alGraph.vNodes[4].arcNode = new ArcNode(1);
        alGraph.vNodes[4].arcNode.nextNode = new ArcNode(7);

        alGraph.vNodes[5] = new VNode();
        alGraph.vNodes[5].arcNode = new ArcNode(2);
        alGraph.vNodes[5].arcNode.nextNode = new ArcNode(6);

        alGraph.vNodes[6] = new VNode();
        alGraph.vNodes[6].arcNode = new ArcNode(2);
        alGraph.vNodes[6].arcNode.nextNode = new ArcNode(5);
        alGraph.vNodes[7] = new VNode();
        alGraph.vNodes[7].arcNode = new ArcNode(3);
        alGraph.vNodes[7].arcNode.nextNode = new ArcNode(4);

        return alGraph;
    }


    public static class ALGraph {
        VNode[] vNodes = new VNode[8];
    }

    public static class VNode {
        ArcNode arcNode;

        public VNode(ArcNode arcNode) {
            this.arcNode = arcNode;
        }

        public VNode() {
        }
    }

    public static class ArcNode {
        int val;
        int vertex;
        ArcNode nextNode;

        public ArcNode(int val, int vertex) {
            this.val = val;
            this.vertex = vertex;
        }

        public ArcNode(int vertex) {
            this.vertex = vertex;
        }
    }
}
