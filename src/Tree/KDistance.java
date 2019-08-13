package Tree;

import java.util.List;

import graph.main;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 * 
 */
public class KDistance {
	
	public static void main(String[] args) {
		int [] list = {4,2,6,1,-1,3,5,7,8};
		Node root = Tree.getBSTFromArray(list);
		BTreePrinter.printNode(root);
		printK(root, 3);
		
	}
	
       public List<Integer> distanceK(Node root, Node target, int K) {
		return null;
        
    }
       
       
       
       
       
       
       
       public static void printK(Node root,int k) {
    	   printK(root, k, 0);
       }
       public static void printK(Node root,int k,int level) {
    	   if(root == null) {
    		   return;
    	   }
    	   if(level == k) {
    		   System.out.println(root.data);
    		   return;
    	   }
    	   printK(root.left, k, level+1);
    	   printK(root.right, k, level+1);
    	   
       }

}
