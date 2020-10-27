package data_structure.tree.online;

import data_structure.tree.TreeUtility;
import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

public class Diameter {


    //7 and 8
    public static void main(String[] args) {
      /*  Node left = new Node(11);
        left.right = new Node(12);
        left.right.left = new Node(13);

        Node right = new Node(21);
        right.left = new Node(22);
        right.left.right = new Node(23);*/

        Node root = TreeUtility.getSampleBinarySearchTree();
        root.right = new Node(3);
        // root.left.left.left = left;
        //root.left.right.left = right;

        BTreePrinter.printNode(root);
        System.out.println(diameterOfBinaryTree(root));
    }


    static int ans;
    public static int diameterOfBinaryTree(Node root) {
        ans = 1;
        depth(root);
        return ans-1 ;
    }

    public  static int depth(Node node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }


}
