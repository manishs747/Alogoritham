package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.online.TreeNode;

public class SumOfChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] list = {4,2,8,7};
		 Node root = Tree.getBSTFromArray(list );
		 BTreePrinter.printNode(root); 
		
		 List<Integer> lists = getRootToLeafNodes(root);
		 System.out.println(lists);
	}
	
	
	public static List<Integer> getRootToLeafNodes(Node root){
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		getRootToLeafNodes(root,stack,result);
		return result;
	}

	public static void  getRootToLeafNodes(Node root,Stack<Integer> stack,List<Integer> list) {
		if(root == null) {
			return;
		}
		stack.push(root.data);
		//System.out.println(stack);
		if(root.left == null && root.right == null) {
			list.add(setFromStack(stack));
		}
		getRootToLeafNodes(root.left,stack,list);
		getRootToLeafNodes(root.right,stack,list);
		stack.pop();
	}
	
	public static int setFromStack(Stack<Integer> stack) {
		Stack<Integer> tmp = new Stack<>();
		while(!stack.isEmpty()) {
			tmp.push(stack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!tmp.isEmpty()) {
			int val = tmp.pop();
			sb.append(val);
			stack.push(val);
		}
		return Integer.parseInt(sb.toString());
	}
	
	
	
	


	public static int sum(Node root) {
		if (root == null) {
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right);
	}
	
	

	//https://leetcode.com/problems/sum-of-left-leaves/
	 public  static int sumOfLeftLeaves(Node root) {
			if (root == null) {
				return 0;
			}
			int sum = 0;
			if(isLeaf(root.left)) {
				sum =  root.left.data;
			}
	        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	  }
	 
	 public static boolean isLeaf(Node root) {
		 if (root == null || root.left != null || root.right != null) {
			 return false;
		 }
		 return true;
	 }
	
	
	public static int rangeSumBST(Node root, int L, int R) {
		if (root == null) {
			return 0;
		}
		int cv = 0;
		if(root.data >= L && root.data <= R) {
			cv = root.data;
		}
		return cv + rangeSumBST(root.left, L, R)  + rangeSumBST(root.right, L, R);
	}
	
	
	//make each node sum of its children
	public static int makeSum(Node root)
	 {   if (root == null)
			   return 0;
		 int temp = root.data;
		 int sum = makeSum(root.left) + makeSum(root.right);
		 if (root.left != null || root.right != null)
			   root.data = sum ;
		return temp + sum;
	 }
	
	
	
	
	
	

}
