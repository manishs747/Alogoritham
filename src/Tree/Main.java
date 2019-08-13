package Tree;

import java.util.Iterator;
import java.util.Stack;

public class Main {
	
	

	public static void main(String[] args) {
		int [] list = {4,2,3,6,1,7};
		Node root = Tree.getBSTFromArray(list);
		BTreePrinter.printNode(root);
		int sum = sumNumber(root);
		System.out.println("SUM:"+sum);
		BTreePrinter.printNode(root);
	}
	
	
	 public static int sumNumber(Node A) {
	     if (A == null) {
	    	 return 0;
	     }
	     return sumNumberHelper(A, 0 ,new Stack<Node> ());
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
			 System.out.println("S :"+ sum);
			// return sum;
		 }
		 int leftSum =  sumNumberHelper(A.left,sum, stack);
		 int right = sumNumberHelper(A.right,sum , stack);
		 stack.pop();
		 return sum +leftSum + right ;
	 }
	 
	
	
    

	
	

}
