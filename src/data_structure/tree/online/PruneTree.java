package data_structure.tree.online;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;


/***
 * Prob: https://leetcode.com/problems/binary-tree-pruning/
 * Solution: https://www.youtube.com/watch?v=77LJc56bwnE
 */
public class PruneTree {

    public static void main(String[] args) {
        Node left = new Node(0, new Node(0), new Node(0));
        Node right = new Node(0, new Node(0), new Node(1));
        Node root = new Node(1, left, right);
        BTreePrinter.printNode(root);
        pruneTree(root);
        BTreePrinter.printNode(root);
    }


    public static Node pruneTree(Node root) {
        if (root == null) {
            return null;
        }
        if (!containOne(root.left)) {
            root.left = null;
        }
        if (!containOne(root.right)) {
            root.right = null;
        }
        pruneTree(root.left);
        pruneTree(root.right);
        if(root.left == null && root.right == null && root != null && root.data == 0){
            root = null;
        }
        return root;
    }

    public static boolean containOne(Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == 1) {
            return true;
        }
        if (containOne(root.left)) {
            return true;
        }
        return containOne(root.right);
    }
}
