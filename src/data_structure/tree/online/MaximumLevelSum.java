package data_structure.tree.online;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaximumLevelSum {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.data = 18;
        BTreePrinter.printNode(root);
        System.out.println(maxLevelSum(root));
    }



    public  static int maxLevelSum(Node root) {
        if(root == null){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1 ;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        int sum = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    if(sum > maxSum){
                        maxLevel = level;
                    }
                    break;
                }
                if(sum > maxSum){
                    maxSum = sum;
                    maxLevel = level;
                }
                sum = 0;
                level++;
                queue.add(null);
            } else {
                sum = sum + current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return maxLevel;
    }
}
