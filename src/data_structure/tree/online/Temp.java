package data_structure.tree.online;

public class Temp {
	
	
	public static void main(String[] args) {
		
	}
	
	 public boolean isUnivalTree(TreeNode root) {
		 if (root == null || (root.left == null && root.right == null)) {
			 return true;
		 }
		
		return isUnivalTreeHelper(root,root.val); 
	 }
	 
	 
	 public  boolean isUnivalTreeHelper(TreeNode root,int val) {
		 if(root == null) {
			 return true;
		 }
		 if(root.val != val) {
			 return false;
		 }
		 if(!isUnivalTreeHelper(root,val)) {
			return false; 
		 }
		 return isUnivalTreeHelper(root,val);
	 }

}
