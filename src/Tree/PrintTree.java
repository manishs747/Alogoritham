package Tree;

import java.util.Iterator;
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
		
		
	
		 public static int sumNumberHelper(Node A,int sum,Stack<Node> stack)  {
			 if (A == null) {
				 return 0;
			 }
			 stack.push(A);
			 if (A.left == null && A.right == null) {
				 Iterator<Node> iter = stack.iterator();
				 while (iter.hasNext()){
					    sum += iter.next().data;
					}
			 }
			 int leftSum =  sumNumberHelper(A.left,sum, stack);
			 int right = sumNumberHelper(A.right,sum , stack);
			 stack.pop();
			 return sum +leftSum + right ;
		 }
	
}
