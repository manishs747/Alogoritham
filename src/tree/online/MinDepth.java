package tree.online;

import tree.BTreePrinter;
import tree.Node;

public class MinDepth {

    public static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
       /* Node root = TreeUtility.getSampleBinarySearchTree();
        root.right.left = null;
        root.right.right = new Node(8);*/

        Node root = new Node(1);
        root.left = new Node(2);
        BTreePrinter.printNode(root);
        System.out.println(minDepth(root));
    }


    public static int minDepth(Node root) {
        if(root == null){
           return 0;
        }
        minDepthHelper(root,0);
        return min;
    }

    public static void minDepthHelper(Node root,int h){
        if (root == null){
            return;
        }
        if(root.left == null && root.right == null){
            min = Math.min(min,h+1);
            return;
        }
        minDepthHelper(root.left,h+1);
        minDepthHelper(root.right,h+1);
    }
}
