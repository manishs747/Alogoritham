package Tree.online;

import Tree.BTreePrinter;
import Tree.Node;
import Tree.Tree;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = Tree.getSampleBinarySearchTree();
		// TreeUtility.printNice(node);
		 BTreePrinter.printNode(root);
		 System.out.println(maxDepth(root));

	}
	
	 public static int maxDepth(Node root) {
		 if(root == null) {
			 return 0;
		 }
		 int childHeight = Math.max(maxDepth(root.left), maxDepth(root.right));
		 return  1+ childHeight;
	}
	 
	

}
