package Tree.online;

import java.util.ArrayList;
import java.util.List;

import Tree.BTreePrinter;
import Tree.Node;
import Tree.Tree;

public class Traversal {
	
	public static void main(String[] args) {
		 Node root = Tree.getSampleBinarySearchTree();
		 root.left.data = 10;
	     BTreePrinter.printNode(root);
	}
	
	
	 public List<Integer> inorderTraversal(Node root) {
		 List<Integer> list = new ArrayList<>();
		 inorderTraversal(root,list);
		 return list;
	        
	}
	 
	 public void inorderTraversal(Node root,List<Integer> list) {
		 if (root == null) {
			 return;
		 }
		 inorderTraversal(root.left);
		 list.add(root.data);
		 inorderTraversal(root.right);
		 
	 }

}
