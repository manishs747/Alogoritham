package data_structure.tree;

import java.util.Stack;

public class Path {

	public static void main(String[] args) {
		 Node root = TreeUtility.getSampleBinarySearchTree();
		 root.left.left.right = new Node(9);
			// TreeUtility.printNice(node);
	     BTreePrinter.printNode(root);
	    // Stack<Node> stack = new Stack<Node>();
		//printRootToLeafPath(root );   //15
		System.out.println(hasPathSum(root,15));
		

	}
	
	
	public static void printRootToLeafPath(Node root) {
		if(root==null){return;}
		Stack<Node> stack = new Stack<Node>();
		printRootToLeafPathRec(root,stack);
	}


	private static void printRootToLeafPathRec(Node root, Stack<Node> stack) {
		if(root==null){return;}
		stack.push(root);
		printRootToLeafPathRec(root.left,stack);
		printRootToLeafPathRec(root.right,stack);
		if(root.left == null && root.right == null){
			System.out.println(stack);
		}
		stack.pop();
	}
	
	static void printPathsRecur(Node root){
		Stack<Integer> path = new Stack<Integer>();
		printPathsRecur(root,path);
		}

		static void printPathsRecur(Node root , Stack<Integer> path) {
		if(root == null){
		return;
		}
		path.push(root.data);
		if(root.left == null && root.right == null){
		System.out.println(path);
		}

		printPathsRecur(root.left, path);
		printPathsRecur(root.right, path);
		path.pop();
		}
		
		
		//https://leetcode.com/problems/path-sum/submissions/
		static boolean  hasPathSum(Node root, int sum) {
			return hasPathHelper(root,0,sum);
		 }
		
		static boolean hasPathHelper(Node root, int ls , int sum) {
			if(root == null) {
				return false;
			}
			ls = ls + root.data;
			if(root.left == null && root.right == null){
				System.out.println(ls);
				if(ls == sum) {
					return true;
				}
			}
			boolean result = hasPathHelper(root.left,ls,sum);
			if (!result) {
				result = hasPathHelper(root.right,ls,sum);
			}
			ls = ls - root.data;
			return result;
			
		}
		
		
	
}
