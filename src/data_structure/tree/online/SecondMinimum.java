package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class SecondMinimum {


    public static void main(String[] args) {
        //[2,2,5,null,null,5,5]
        //[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.data = 1;
        root.left.data = 1;
        root.right.data = 1;
        root.left.left.data = 1;
        root.left.right.data = 1;
        root.right.left.data = 1;
        root.right.right.data = 1;

        BTreePrinter.printNode(root);
        System.out.println(findSecondMinimumValue(root));
    }


    static int s = -1;

    public static int findSecondMinimumValue(Node root) {
        findSecondMinimumValueHelper(root);
        return s;
    }

    public static void findSecondMinimumValueHelper(Node root) {
        if (root == null || root.left == null) {
            return;
        }
        if (s != -1 && root.data > s) {
            return;
        }
        int max = Math.max(root.left.data, root.right.data);
        if(max != root.data && ( s == -1 || s > max) ){
            s = max;
        }
        findSecondMinimumValueHelper(root.left);
        findSecondMinimumValueHelper(root.right);
    }


}
