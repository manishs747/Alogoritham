package data_structure.tree.online.lca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCA3DFS {


    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
    }


    public Node lowestCommonAncestorDFS(Node root,List<Node> nodes){
        if (root == null || nodes == null || nodes.isEmpty()) return null;
        Set<Node> targetSet = new HashSet<>(nodes);
        return dfs(root, targetSet);
    }

    private Node dfs(Node root, Set<Node> targets) {
        if (root == null) return null;
        // If root itself is one of the targets
        if (targets.contains(root)) {
            return root;
        }
        Node left = dfs(root.left, targets);
        Node right = dfs(root.right, targets);
        // If both children return non-null, root is LCA
        if (left != null && right != null) {
            return root;
        }
        // Otherwise return whichever side has a target
        return left != null ? left : right;
    }
}
