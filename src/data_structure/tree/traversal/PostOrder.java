package data_structure.tree.traversal;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class PostOrder {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        printPostOrder(root);
    }


    private static void printPostOrder(Node node) {
        if(node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+" ");
    }

    /*
    https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
     */
    private static void printPostOrderOneStack(Node node) {

    }

   /*
       https://www.geeksforgeeks.org/iterative-postorder-traversal/
    */
    private static void printPostOrderTwoStack(Node node) {

    }





}
