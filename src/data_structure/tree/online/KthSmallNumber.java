package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class KthSmallNumber {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        System.out.println(kthSmallest(root,4));
    }

   static int count = 0;
    static int val = 0;
    public static void inorder(Node root , int k){
      if(root == null){
          return;
      }
        inorder(root.left,k);
        count++;
        if(count == k){
            val = root.data;
            return;
        }
        inorder(root.right,k);
    }
    public static int kthSmallest(Node root, int k) {
        inorder(root,k);
        return val;
    }




}
