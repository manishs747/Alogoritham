package Tree;

import Tree.online.TreeNode;

public class Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = Tree.getSampleBinarySearchTree();
		 BTreePrinter.printNode(root);
		
		
	}
	
	   public static TreeNode invertTree(TreeNode root) {
		   if(root == null) {
			   return root;
		   }
		   TreeNode tmp = root.left;
		   root.left = root.right;
		   root.right = tmp;
		   invertTree(root.right);
		   invertTree(root.left);
		   return root;
	    }
	
	
	
	public static boolean areMirror(NodeT node1, NodeT node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		
		if(node1.data != node2.data ){
			return false;
		}else{
			return areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);
		}
	}
	

	
	public static void mirror(Node root){
	    if (root == null){
	       return ;
	    }
	    Node tmp = root.left;
	    root.left =  root.right;
	    root.right = tmp;
	    mirror(root.left);
	    mirror(root.right);
	}
	
	



	private static void swapNode(NodeT node) {
		NodeT temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}
