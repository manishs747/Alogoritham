package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class GreaterSumTree {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        //BTreePrinter.printNode(bstToGst(root));
    }
    public static int sum = 0;
    public static int prev = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if(null == root || (null == root.left && null == root.right )){
            return root;
        }
        printInOrder(root);
        updateInOrder(root);
        return root;
    }

    private static void printInOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        printInOrder(root.left);
        sum = sum + root.val;
        printInOrder(root.right);
    }

    private static void updateInOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        updateInOrder(root.left);
        sum = sum - prev;
        prev = root.val;
        root.val = sum;
        updateInOrder(root.right);
    }
}
