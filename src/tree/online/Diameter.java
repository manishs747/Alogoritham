package tree.online;

import tree.BTreePrinter;
import tree.Node;
import tree.TreeUtility;

public class Diameter {


    //7 and 8
    public static void main(String[] args) {
        Node left = new Node(11);
        left.right = new Node(12);
        left.right.left = new Node(13);

        Node right = new Node(21);
        right.left = new Node(22);
        right.left.right = new Node(23);

        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left.left.left = left;
        root.left.right.left = right;

        BTreePrinter.printNode(root);
        System.out.println(diameterOfBinaryTree(root));
    }


    public static int diameterOfBinaryTree(Node root) {
        return helper(root);
    }

    public static int helper(Node node) {
        if(node == null){
            return 0;
        }
        return helper(node.left)+ 1+ helper(node.right);
    }
}
