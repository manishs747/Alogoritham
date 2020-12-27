package data_structure.tree.operation;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;
import data_structure.tree.online.TreeNode;

/*

https://leetcode.com/problems/delete-node-in-a-bst/
https://leetcode.com/problems/delete-nodes-and-return-forest/

 */
public class Delete {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.right.right.right = new Node(8);
        BTreePrinter.printNode(root);
        Node deleted = deleteNode(root, 4);
        BTreePrinter.printNode(deleted);
    }


    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        Node min = getMin(root.right);
        root.right =  deleteNode(root.right, min.data);
        root.data = min.data;
        return root;
    }

    public static Node getMin(Node node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        TreeNode min = getMin(root.right);
        root.right =  deleteNode(root.right, min.val);
        root.val = min.val;
        return root;
    }

    public static TreeNode getMin(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }


}
