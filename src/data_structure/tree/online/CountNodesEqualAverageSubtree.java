package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
 */
public class CountNodesEqualAverageSubtree {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();

        BTreePrinter.printNode(root);
        System.out.println(averageOfSubtree(root));
    }

    public static int STATIC_COUNT = 0;
    public static int averageOfSubtree(Node root) {
        averageOfSubtreeHelper(root);
        return STATIC_COUNT;
    }
    public static int[] averageOfSubtreeHelper(Node root) {
        if(root == null) return new int []{0,0};
        int [] left = averageOfSubtreeHelper(root.left);
        int right [] = averageOfSubtreeHelper(root.right);
        int sum = left[0]+right[0]+root.data;
        int count = left[1]+right[1]+1;
        if(sum/count == root.data) STATIC_COUNT++;
        return new int []{sum,count};
    }
}
