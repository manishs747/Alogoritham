package data_structure.tree.online.sumpath;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class SumPath {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        System.out.println(hasPathSum(root,8));
    }

    public  static boolean hasPathSum(Node root, int sum) {
        if(root == null ) return false;
        if( root.left == null && root.right == null && root.data == sum) return true;
        return hasPathSum(root.left,sum-root.data) || hasPathSum(root.right,sum-root.data);
    }
}
