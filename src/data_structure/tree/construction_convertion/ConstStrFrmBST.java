package data_structure.tree.construction_convertion;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

/*
https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstStrFrmBST {


    public static void main(String[] args) {

        Node root = new Node(1, new Node(2, null, new Node(4)), new Node(3));
        //Node root = new Node(1);
        BTreePrinter.printNode(root);
        System.out.println(tree2str(root));

    }


    /*
       1
      / \
     /   \
     2   3
    /
    4
    "1(2(4))(3)"
     */
    public static String tree2str(Node t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return Integer.toString(t.data);
        }
        if (t.right == null) {
            return t.data + "(" + tree2str(t.left) + ")";
        }

        return t.data + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

}
