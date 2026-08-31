package data_structure.tree.online.lca;

import java.util.*;

public class LCA3DFSNARR {
    static class Node {
        public int val;
        public List<Node> childrens = new ArrayList<>();
        Node(int val) {
            this.val = val;
        }
    }

    private Node lca = null;

    public Node lowestCommonAncestorDFS(Node root, Set<Node> nodes){
         if (root == null || nodes == null || nodes.isEmpty()) return null;
         dfsCount(root, nodes);
         return lca;
    }

    private Set<Node> dfs(Node root, Set<Node> targets) {
        if (root == null || lca != null) return new HashSet<>();
        Set<Node> found = new HashSet<>();
        if (targets.contains(root)) { // If current node is one of the targets
            found.add(root);
        }
        for (Node children: root.childrens){
            if (lca != null) break;
            Set<Node> childFound = dfs(children,targets);
            found.addAll(childFound);
        }
        if(lca == null && found.containsAll(targets)){
            lca = root;
        }
      return found;
    }

    private int dfsCount(Node root, Set<Node> targets) {
        if (root == null || lca != null) return 0;
        int count = 0;
        if(targets.contains(root)) count++;
        for (Node children:root.childrens ){
            count += dfsCount(children,targets);
            if(lca != null) return 0;
        }
        if(lca == null && targets.size() == count){
            lca = root;
        }
        return count;
    }






    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        root.childrens.add(n2);
        root.childrens.add(n3);
        n2.childrens.add(n4);
        n2.childrens.add(n5);
        n3.childrens.add(n6);
        n3.childrens.add(n7);

        LCA3DFSNARR solver = new LCA3DFSNARR();

        System.out.println("LCA of [4,5]: " +
                solver.lowestCommonAncestorDFS(root, Set.of(n4, n5)).val);
    }

    }
