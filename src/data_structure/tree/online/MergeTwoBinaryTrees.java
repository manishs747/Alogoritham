package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

/*
 * https://leetcode.com/problems/merge-two-binary-trees/
 */

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
	   Node t1  = new Node(1);
	   Node left = new Node(3);
	   left.left = new Node(5);
	   t1.left = left;
	   t1.right = new Node(2);

	   BTreePrinter.printNode(t1);
	   
	   Node t2  = new Node(2);
	   Node right = new Node(3);
	   right.right = new Node(7);
	   t2.right = right;
	   Node lft = new Node(1);
	   lft.right = new Node(4);
	   t2.left = lft;
	   BTreePrinter.printNode(t2);

	   Node resut = mergeTrees(t1,t2);
	   BTreePrinter.printNode(resut);
	}
	
	  public static Node mergeTrees(Node t1, Node t2) {
		  if(t1 != null && t2 != null) {
				 t1.data = t1.data +t2.data;

			}
			if(t1 == null) {
				return t2;
			}
			if(t2 == null) {
				return t1;
			}
			 t1.left =  mergeTrees(t1.left,t2.left);
			 t1.right = mergeTrees(t1.right,t2.right);
			 return t1;
		  
	 }
	  
	

}
