package data_structure.tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeUtility {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	/*
	 * 
	 *          1
	 *       2     3
	 *     4   5 6   7
	 *        
	 * 
	 * 
	 * 
	 * 
	 */
	public static Node getSampleTree() {
		  Node a = new Node(1);
		  Node b = new Node(2);
		  Node c = new Node(3);
		  Node d = new Node(4);
		  Node e = new Node(5);
		  Node f = new Node(6);
		  Node g = new Node(7);
		 
		  a.left = b;
		  a.right = c;
		  b.left = d;
		  b.right = e;
		  c.left = f;
		  c.right = g;
		return a;
	}
	
	
	/*
	
	     4
	   2   6
	  1 3 5 7
		 */

		public static Node getSampleBinarySearchTree() {
			// build the simple datastructure.strings.datastructure.strings.tree from chapter 11.
			Node root = new Node(4);
			TreeOperation.insert(root, 2);
			TreeOperation.insert(root, 6);
			TreeOperation.insert(root, 1);
			TreeOperation.insert(root, 3);
			TreeOperation.insert(root, 5);
			TreeOperation.insert(root, 7);
			return root;
		}
	
	
	
	
	
	public static void topView(Node root){
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();		
		getTopViewHash(root, 0, map);
		 Set<Integer> set = map.keySet();
		 for (Integer key : set) {
			System.out.print(map.get(key)+" ");
		  }
	}
	
	public static void getTopViewHash(Node root, int hd, Map<Integer,Integer> map){
		if(root == null){
			return;
		}
		if(!map.containsKey(hd)){
			map.put(hd,(Integer) root.data);
		 }
		getTopViewHash(root.left, hd-1, map);
		getTopViewHash(root.right, hd+1, map);
	}
	
	
	
	
	
	
	
	
	

	

	
	
	public static int printHeight(NodeT node) {
		if(node==null){return -1;}
		int lHeight = printHeight(node.left);
	    int rHeight = printHeight(node.right);
	    return (lHeight < rHeight) ? rHeight + 1 : lHeight + 1;
	}
	
	public static void inOrderSuccessor(NodeT root, NodeT n){
		
	}
	
	public static  NodeT  getMin(NodeT node){
		
		NodeT current = node;
		while(current.left != null){
			current = current.left;
		}
		return node;
	}
	
	
	
	public static int size(NodeT node)
	{
		if(node == null){
			return 0;
		}
		return size(node.left)+ 1+ size(node.right);
	}
	
	
	public static boolean checkBST(NodeT<Integer> node) {
		if (node == null || (node.left == null && node.right == null))
			return true;
		// check bst condtion for current node
		if (node.left != null && node.left.data >= node.data) {
			return false;
		}
		if (node.right != null && node.right.data <= node.data) {
			return false;
		}
		// false if, recursively, the left or right is not a BST */
		if (!checkBST(node.left) || !checkBST(node.right))
			return false;
		return true;
	}

    public static int t = Integer.MIN_VALUE;
	public static boolean checkBSTG(NodeT<Integer> root) {
		  if(root==null)
	            return true;
	        boolean l = checkBST(root.left);
	        if(l==false)
	            return l;
	        if(t<root.data)
	            t = root.data;
	        else
	            return false;
	        return checkBST(root.right);
	       
	}
	
	public static void printNice(NodeT<Integer> root)
	 {
	  if (root == null)
	   return;
	  else
	  {
	   System.out.print(root.getData());
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
