package data_structure.tree.online;

import data_structure.tree.TreeUtility;
import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

/*
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class SearcBST {

	public static void main(String[] args) {
		Node root = TreeUtility.getSampleBinarySearchTree();
		BTreePrinter.printNode(root);
		root = searchBST(root,2);
		BTreePrinter.printNode(root);
	}
	
	
	  public static Node searchBST(Node root, int val) {
		  Node node = null;
		  if(root == null) {
			 return null; 
		  }
		  if(root.data == val) {
			  return root;
		  }
		  node = searchBST(root.left,val);
		  if(node != null) {
			  return node;
		  }
		  node =searchBST(root.right,val);
	      return node;  
	 }
	  
	 

}
