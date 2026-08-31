package data_structure.tree.online.lca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCA3 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    /**
     *
     */

    public static void main(String[] args) {

    }

    public Node lowestCommonAncestor(List<Node> nodes){
        if (nodes == null || nodes.isEmpty()) return null;
        Node lca = nodes.get(0);  // start with the first node
        for (int i = 1; i < nodes.size(); i++) {
            lca = lowestCommonAncestor(lca, nodes.get(i)); // check if two of each node is same
            if (lca == null) return null; // early exit if no common ancestor
        }
        return lca;
    }
     // most important
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> pset = new HashSet<>();
        Node current = p;
        while (current != null){
            pset.add(current);
            current = current.parent;
        }

        current = q;
        while (current != null){
            if(pset.contains(current))
                return current;
            current = current.parent;
        }
        return null;
    }


    public Node lowestCommonAncestor2(Node p, Node q) {
        Node p1 = p ,p2 = q;
        while (p1 != p2){
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;
        }
        return p1;
    }



}
