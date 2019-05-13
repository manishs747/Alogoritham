package Tree;

public class FindOrGet {
	
	
	public static void main(String[] args) {
		
		
		int[] list = {4,2,3,1,6,5,7};
		Node root = Tree.getBSTFromArray(list );
		//BTreePrinter.printNode(root);
		//;System.out.println(search(root, 6));
		System.out.println(contains(root, 8));
		
	}
	

	//finds a node in tree
	public static Node search(Node current, int value) {
		if (current == null || current.data == value)
			return current;
		if (current.data > value)
			return search(current.left, value);
		return search(current.right, value);
	}
	
	public static boolean contains(Node root ,int value){
		if( root == null){
			return false;
		}
		if (root.data == value) {
			return true;
		}
		if(value < root.data){
			return contains(root.left, value);
		}else{
			return contains(root.right, value);
		}
	}
	
	
	//https://www.youtube.com/watch?v=5cPbNCrdotA
	//https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	/*
	 * 1) If right subtree of node is not NULL, then succ lies in min value  in  right subtree.
	 * 2)If right sbtree of node is NULL, then start from root and us search like technique. Do following.
Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
     deepest parent node which is greater than node
	 */
	public static Node FindInOrderSuccessor(Node root,Node node){
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return node.right.min();
		}
		Node succ = null;
		while(root != null) {
			if (node.data == root.data) {
				break;
			}
			if (node.data < root.data) { //go left
				succ = root;
				root = root.left;
			}else { // go right
				root = root.right;
			}
		}
		return succ;
	}
	
	
	
	public static  Node  getMin(Node node){
		Node current = node;
		while(current.left != null){
			current = current.left;
		}
		return node;
	}
	

}
