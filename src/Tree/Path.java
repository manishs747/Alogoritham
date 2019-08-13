package Tree;

import java.util.Stack;

import Tree.online.TreeNode;

public class Path {
	
	
	public static void main(String[] args) {
		Node root = Tree.getSampleBinarySearchTree();
		BTreePrinter.printNode(root);
	}
	
	
	
	
	
	
	
	static void printPathsRecur(Node root){
		Stack<Node> stack = new Stack<>();
		printPathsRecurHelper(root, stack);
	}

	//Lovely solution
	static void printPathsRecurHelper(Node root,Stack<Node> stack) {
		if(root == null) {
			return;
		}
		stack.push(root);
		if(root.left == null && root.right == null) {
			System.out.println(stack);
		}
		printPathsRecurHelper(root.left, stack);
		printPathsRecurHelper(root.right, stack);
		stack.pop();		
	}
	
	
	  public static int sumNumbers(TreeNode root) {
		  Stack<TreeNode> stack = new Stack<>();
		return printPathsRecurHelper(root, stack,0); 
		
	  }
	  
		static int printPathsRecurHelper(TreeNode root,Stack<TreeNode> stack,int sum) {
			if(root == null) {
				return 0;
			}
			stack.push(root);
			if(root.left == null && root.right == null) {
				System.out.println(stack);
				sum = sum  + getStackValue(stack);
			}
			int left = printPathsRecurHelper(root.left, stack,sum);
			int right = printPathsRecurHelper(root.right, stack,sum);
			stack.pop();
			return sum + left + right ;
		}
	

		public static int getStackValue(Stack<TreeNode> stack) {
			Stack<TreeNode> tmp = new Stack<>();
			int sum = 0;
			while(!stack.isEmpty()) {
				tmp.push(stack.pop());
			}
			while(!tmp.isEmpty()) {
				TreeNode val = tmp.pop();
				sum = sum*10 + val.val;
				stack.push(val);
			}
			return sum;
		}
	
	
	
	
	
//	https://www.geeksforgeeks.org/print-path-between-any-two-nodes-in-a-binary-tree/
/*	
	   4       
	  / \   
	 /   \  
	 2   6   
	/ \ / \ 
	1 3 5 7    
	
	 for 1 and 5 
	  1->2->4->6->5
	 *
	 */
	
	public static void printPath(Node root,int a ,int b) {
		
	}
	
	
	
	
	
	
	

}
