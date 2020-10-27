package data_structure.tree.online;

import data_structure.tree.TreeUtility;
import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

public class DeleteLeaves {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left = new Node(2,new Node(2),null);
        root.right.left.data = 2;
        //  Node root = new Node(1, new Node(1, new Node(1), null), null);

        BTreePrinter.printNode(root);
        root = removeLeafNodes(root, 2);
        BTreePrinter.printNode(root);
    }


    /*
    https://www.geeksforgeeks.org/delete-leaf-nodes-with-value-k/?ref=rp
    https://leetcode.com/problems/delete-leaves-with-a-given-value/
     */
    public static Node removeLeafNodes(Node root, int target) {
        if (root == null) {
            return null;
        }
        removeLeafNodes(root.left, target);
        removeLeafNodes(root.right, target);
        if (isValid(root.left, target)) {
            root.left = null;
        }
        if (isValid(root.right, target)) {
            root.right = null;
        }
        if (isValid(root, target)) {
            return null;
        }
        return root;
    }

    static boolean isValid(Node node, int target) {
        return node != null && node.data == target && node.left == null && node.right == null;
    }
}
