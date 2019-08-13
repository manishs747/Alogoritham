package Tree.practice;

import java.util.ArrayList;
import java.util.List;

import Tree.BTreePrinter;
import Tree.Node;
import Tree.Tree;

public class IncreasingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {4,2,1,3,6,5,7};	
		

		 Node root = Tree.getBSTFromArray(list);
		// TreeUtility.printNice(node);
		 BTreePrinter.printNode(root);
		 Node newRoot = increasingBST(root);
		 BTreePrinter.printNode(newRoot);
	}
	
	
	
	  public static Node increasingBST(Node root) {
	        Node newRoot = null ;
	        Node tmp = newRoot;
	        List<Integer> list = new ArrayList<>();
	        inOrder(root, list);
	        for (Integer data : list) {
				if(tmp == null) {
					newRoot = new Node(data);
					tmp = newRoot;
				}else {
					tmp.right = new Node(data);
					tmp = tmp.right;
				}
			}
	        return newRoot;
	  }
	  
	  
	  public static  void inOrder(Node root ,List<Integer> list) {
		  if(root == null) {
			 return; 
		  }
		  inOrder(root.left, list);
		  list.add(root.data);
		  inOrder(root.right, list);
	  }
	  
	  

}
