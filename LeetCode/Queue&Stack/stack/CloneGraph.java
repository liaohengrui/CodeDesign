package com.example.demo;

import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/8
 */
@SuppressWarnings("ALL")
public class CloneGraph {
    Set set = new HashSet();
    Queue<UndirectedGraphNode> BFSQueue = new LinkedList();
    Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        set.add(node);
        BFSQueue.offer(node);
        while (!BFSQueue.isEmpty()) {
            UndirectedGraphNode root = BFSQueue.poll();
            UndirectedGraphNode cloneNode;
            if (cloneMap.containsKey(root)) {
                cloneNode = cloneMap.get(root);
            } else {
                cloneNode = new UndirectedGraphNode(root.label);
                cloneMap.put(root, cloneNode);
            }
            for (UndirectedGraphNode neighborhood : root.neighbors) {
                UndirectedGraphNode cloneNeighborhood;
                if (cloneMap.containsKey(neighborhood)) {
                    cloneNeighborhood = cloneMap.get(neighborhood);
                } else {
                    cloneNeighborhood = new UndirectedGraphNode(neighborhood.label);
                    cloneMap.put(neighborhood, cloneNeighborhood);
                }
                if (set.add(neighborhood)) {
                    BFSQueue.offer(neighborhood);
                    cloneNode.neighbors.add(cloneNeighborhood);
                } else {
                    cloneNode.neighbors.add(cloneNeighborhood);
                }
            }
        }
        return cloneMap.get(node);
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}



