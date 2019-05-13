package Tree;

import java.util.Stack;


//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
//https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
//https://www.geeksforgeeks.org/print-the-nodes-of-binary-tree-as-they-become-the-leaf-node/
//https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
//https://www.geeksforgeeks.org/print-nodes-k-distance-root-iterative/

public class PrintTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = Tree.getSampleBinarySearchTree();
		 //root.left.left.right = new Node(9);
			// TreeUtility.printNice(node);
	     BTreePrinter.printNode(root);
	     Stack<Node> stack = new Stack<Node>();
	//	printRootToLeafPath(root );

	}
	
	//lovely solution
		static void printPathsRecur1(Node root){
			Stack<Integer> path = new Stack<Integer>();
			printPathsRecur1(root,path);
		}
		
		static void printPathsRecur1(Node root ,Stack<Integer> path) {
			if(root == null){
				return;
			}
			path.push(root.data);
			if(root.left == null && root.right == null){
				System.out.println(path);
			}
			
			printPathsRecur1(root.left, path);
			printPathsRecur1(root.right, path);
			path.pop();
		}
		
		
		static void printKDistant(Node root, int k) {
			if(root == null){
				return;
			}
			if(k==0){
				System.out.println(root.data);
				return;
			}
			printKDistant(root.left, k-1);
			printKDistant(root.right, k-1);
		}
		
		
	
	
	public static void printRootToLeafPath(Node root) {
		if(root==null){return;}
		Stack<Node> stack = new Stack<Node>();
		printRootToLeafPathRec(root,stack);
	}


	private static void printRootToLeafPathRec(Node root,Stack<Node> stack) {
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
		printPathsRecur1(root,path);
		}

		static void printPathsRecur(Node root ,Stack<Integer> path) {
		if(root == null){
		return;
		}
		path.push(root.data);
		if(root.left == null && root.right == null){
		System.out.println(path);
		}

		printPathsRecur1(root.left, path);
		printPathsRecur1(root.right, path);
		path.pop();
		}
	
}
