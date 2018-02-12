package Tree;

public class SumOfChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Node a = TreeUtility.getSampleTree();
		  printNice(a);
		  System.out.println();
		  makeSum(a);
		  printNice(a);
	}


	
	
	
	public static int makeSum(Node root)
	 {   if (root == null)
			   return 0;
		 int temp = root.data;
		 int sum = makeSum(root.left) + makeSum(root.right);
		 if (root.left != null || root.right != null)
			   root.data = sum ;
		return temp + sum;
	 }
	
	public static void printNice(Node root)
	 {
	  if (root == null)
	   return;
	  else
	  {
	   System.out.print(root.data);
	   if (root.left != null)
	   {
	    System.out.print("L->[");
	    printNice(root.left);
	    System.out.print("]");
	   }
	   if (root.right != null)
	   {
	    System.out.print("R->[");
	    printNice(root.right);
	    System.out.print("]");
	   }
	  }
	  
	 }

}
