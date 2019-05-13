package Tree;


//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem



public class Ancestor {
	 //  
	   
	   public static void main(String[] args) {
		   int [] list = {5, 2, 12, 1 ,3 ,9, 21,19,25};
		   Node root = Tree.getBSTFromArray(list);
		   BTreePrinter.printNode(root);
		  System.out.println( distanceBetween2Nodes(root, 1, 25));
		  System.out.println( distanceBetween2Nodes(root, 2, 9));
		  System.out.println( distanceBetween2Nodes(root, 1, 3));
		  System.out.println( distanceBetween2Nodes(root, 9, 19));
		  System.out.println( distanceBetween2Nodes(root, 3, 21));
		  System.out.println( distanceBetween2Nodes(root, 3, 9));
	}
	   
	   
	   
	   
	 
	   
	   
	   
	   
	   
	   public static Node lca(Node root, int v1, int v2) {
		   if (v1 < root.data && v2 < root.data) {
			   return  lca(root.left, v1, v2);
		   }
		   if (v1 > root.data && v2 > root.data){
			   return lca(root.right, v1, v2);
		   }
		   return root;
	   }
	   
	   //https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
	   static int distanceBetween2Nodes(Node root, int a, int b)   {
		   Node lca = lca(root, a, b);
		   return distanceBetweenRootToNodes(lca, a,0) + distanceBetweenRootToNodes(lca, b,0);
	   }
	   
	   
	   static int distanceBetweenRootToNodes(Node root, int data,int depth)    {
		   if (root.data == data ) {
			   return depth;
		   }
		   if (data < root.data ) {
			   return distanceBetweenRootToNodes(root.left, data, depth+1);
		   } else {
			   return distanceBetweenRootToNodes(root.right, data, depth+1);
		   }
	   }
	   
	   public static Node lcaOld(Node root, int v1, int v2) {
		  
		  if (v1 > v2) {
			  int tmp = v1 ;
			  v1 = v2;
			  v2 = tmp;
		  }
		   if (v1 <= root.data && v2 >= root.data) {
			   return root;  
		   }
		   if (v1 < root.data && v2 < root.data) {
			  return  lca(root.left, v1, v2);
		   }else {
			  return lca(root.right, v1, v2);
		   }
	   }

	

}
