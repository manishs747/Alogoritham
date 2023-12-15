package data_structure.tree.online;

import data_structure.tree.Node;
import data_structure.tree.TreeOperation;

public class MaximumDepth {

    public static void main(String[] args) {
        Node root = new Node(4,null,new Node(2));
        System.out.println(maxDepth(root));
    }


    public static int maxDepth(Node root) {
      if(root == null) return 0;
      return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


}
