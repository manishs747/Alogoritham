package data_structure.graph.leetcode;


import data_structure.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
https://leetcode.com/problems/clone-graph/description/
 */
public class CloneGraph {
   public static Map<Node,Node> visited = new HashMap<>();
    public static void main(String[] args) {

    }


    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(visited.containsKey(node)) return visited.get(node);
        Node cloneNode = new Node(node.id, new ArrayList<>());
        visited.put(node,cloneNode);
        for (Node child : node.adjacent) {
            cloneNode.adjacent.add(child);
        }
        return cloneNode;
    }


    public static void dfs(Node node , Map<Node,Node> visited){

    }
}
