package data_structure.tree;

import data_structure.tree.traversal.Inorder;

import java.util.ArrayList;
import java.util.List;

public class Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = TreeUtility.getSampleTree();
		 //TreeUtility.printNice(root);
		
	}


	/*
	 https://leetcode.com/problems/symmetric-tree/
	 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 */
	public boolean isSymmetric(Node root) {
		if(root == null){
			return true;
		}
		return areMirror(root.left,root.right);
	}
	
	public static boolean areMirror(Node node1, Node node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		return  (node1.data == node2.data ) && areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);
	}

	/*
	Find the inorder traversal of both the Binary Trees, and check whether one traversal is reverse of another or not.
	If they are reverse of each other then the trees are mirror of each other, else not.
	 */

	public static boolean areMirrorIterative(Node node1, Node node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		List<Node> list1 = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();

		Inorder.getInorder(node1,list1);
		Inorder.getInorder(node1,list2);

		if (list1.size() != list1.size())
			return false;

		int size = list1.size();
        for(int i=0;i < size;i++){
        	if(list1.get(i) != list2.get(size-i));
				return false;
		}
		return true;
	}
	

	
	//code to make mirror of it self
	public static void mirror(NodeT node){
		if(node == null){
			return;
		}
		mirror(node.left);
		mirror(node.right);
		swapNode(node);
	}





	private static void swapNode(NodeT node) {
		NodeT temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}
