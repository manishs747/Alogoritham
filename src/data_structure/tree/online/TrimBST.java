package data_structure.tree.online;


public class TrimBST {

	public static void main(String[] args) {

		TreeNode root = TreeNodePrinter.getSampleTree();
		TreeNodePrinter.printNode(root);
		TreeNodePrinter.printNode(trimBST(root,1,7));
		//trimBST(root,3,5);

	}



	/*
	  ///https://leetcode.com/problems/trim-a-binary-search-tree/
	 */
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null){
			return root;
		}
		if(root.val >= L && root.val <= R){
			root.left = trimBST(root.left ,L,R);
			root.right = trimBST(root.right ,L,R);
		}else{
			if(root.val < L){
				return trimBST(root.right,L,R);
			}
			if(root.val > R){
				return trimBST(root.left,L,R);
			}
		}
		return root;
	}

}
