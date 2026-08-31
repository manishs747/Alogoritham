package data_structure.graph.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    private Map<Node, Node> visited = new HashMap<>();

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if(node == null) return null;
        // already cloned
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        for (Node childNode : node.neighbors){
           Node curChildnode =  dfs(childNode);
           if(curChildnode != null){
               cloneNode.neighbors.add(curChildnode);
           }
        }
        return cloneNode;
    }
}
