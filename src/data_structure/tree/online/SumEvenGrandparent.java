package data_structure.tree.online;

import data_structure.tree.TreeUtility;
import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

public class SumEvenGrandparent {

      int sum = 0;


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left = null;
        root.data = 50;
        root.right.data = 54;
        root.right.left.data = 98;
        root.right.right.data = 6;
        root.right.right.right = new Node(34);


        BTreePrinter.printNode(root);
        SumEvenGrandparent s = new SumEvenGrandparent();
        System.out.println(s.sumEvenGrandparent(root));
    }

    public  int sumEvenGrandparent(Node root) {
         sumEvenGrandparent(root, null,null);
         return sum;
    }

    public  void sumEvenGrandparent(Node root, Node gp, Node p) {
        if (root == null) {
            return ;
        }
        if (null != gp && gp.data % 2 == 0) {
            sum += root.data;
        }
        sumEvenGrandparent(root.left, p, root);
        sumEvenGrandparent(root.right, p, root);
    }


}

