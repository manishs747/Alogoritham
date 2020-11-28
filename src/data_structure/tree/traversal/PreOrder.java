package data_structure.tree.traversal;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.Stack;

public class PreOrder {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        printPreOrder(root);
        System.out.println();
        printPreOrderIterative(root);
    }

    public static void printPreOrder(Node node) {
        if(node==null){return;}
        System.out.print( node.data  + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }


    private static void printPreOrderIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node tmp = stack.pop();
            if(null == tmp){
                continue;
            }
            System.out.print( tmp.data  + " ");
            stack.push(tmp.right);
            stack.push(tmp.left);
        }
    }

    public static void printPreOrderIterativeOther(Node root) {
        if(root==null){
            return;}
        Stack<Node> stack = new Stack<Node>();
        while(true){
            while(root != null){
                System.out.print( root.data  + " ");
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            root = stack.pop().right;
        }
    }
}
