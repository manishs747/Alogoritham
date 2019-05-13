package Tree;

public class SumOfChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Node a = Tree.getSampleBinarySearchTree();
		 Tree.printTreeNice(a); 
		  System.out.println();
		  makeSum(a);
		  Tree.printTreeNice(a); 
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
