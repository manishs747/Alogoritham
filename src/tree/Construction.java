package tree;

public class Construction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	static Node buildTreeFromPreInOrder(int[] preorder, int[] inorder){
		
		return buildTreeFromPreInOrderHelper(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1);
	}
	
	static Node buildTreeFromPreInOrderHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
		if(preStart > preEnd || inStart > inEnd){
			return null;
		}
		int currentRoot = preorder[preStart];
		Node root = new Node(currentRoot);
		
		
	
	    return root;
	}

}
