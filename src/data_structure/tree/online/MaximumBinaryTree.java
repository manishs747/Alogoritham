package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

/**
 *   https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int [] arr = {3,2,1,6,0,5};
        Node  node =  constructMaximumBinaryTree(arr);
        BTreePrinter.printNode(node);
    }


    public static Node constructMaximumBinaryTree(int[] nums) {
      return   constructMaximumBinaryTreeHelper(nums,0,nums.length-1);
    }



    public static Node constructMaximumBinaryTreeHelper(int[] nums,int start,int end) {
        if(start > end){
           return null;
        }
        if(start == end){
           return new Node(nums[start]);
        }
        int maxIndex = getMaxIndex(nums,start,end);
        Node root = new Node(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeHelper(nums,start,maxIndex-1);
        root.right = constructMaximumBinaryTreeHelper(nums,maxIndex+1,end);
        return root;
    }

    public static int getMaxIndex(int[] nums,int start,int end){
        int maxIndex = start;
        for (int i = start+1;i <= end;i++){
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }



}
