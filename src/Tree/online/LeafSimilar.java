package tree.online;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
	
	
	
	public static void main(String[] args) {
		
		
		 
		
	}
	
	
	 public ArrayList<Integer> inorderTraversal(TreeNode A) {
		  ArrayList<Integer> list = new ArrayList<>();
		  postorderTraversal(A,list);
		  return list;
	 }
	 
	 public void postorderTraversal(TreeNode A,List<Integer> list) {
		 if (null == A) {
			 return;
		 }
		 list.add(A.val);
		 postorderTraversal(A.left,list);
		 postorderTraversal(A.right,list);
	 }
	  
	  
	

}
