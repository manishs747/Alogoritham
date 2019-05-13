package Tree;

public class Tree {
	private static Node root;
	
	public Tree(int data) {
		root = new Node(data);
	}
	
	public static void main(String[] args) {
		root = getSampleBinarySearchTree();
		BTreePrinter.printNode(root);
	}
	
	
	public void insertNode( int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	} 



	/*
		   4       
		  / \   
		 /   \  
		 2   6   
		/ \ / \ 
		1 3 5 7     

	 */
	public static Node getSampleBinarySearchTree() {
		int [] list = {4,2,6,1,3,5,7};	
		return getBSTFromArray(list);
	}
	
	
	public static Node getBSTFromArray(int [] list) {
		// build the simple tree from chapter 11.
		Node root = null;
		for (int value : list) {
			if (root == null) {
				root = new Node(value);
			}else {
				root.insert(value);
			}
		}
		return root;
	}
	

	public static int printHeight(Node node) {
		if(node==null){return -1;}
		int lHeight = printHeight(node.left);
		int rHeight = printHeight(node.right);
		return (lHeight < rHeight) ? rHeight + 1 : lHeight + 1;
	}


	public static int size(Node node){
		if(node == null){
			return 0;
		}
		return size(node.left)+ 1+ size(node.right);
	}





	public static void printTreeNice(Node root)
	{
		if (root == null)
			return;
		else
		{
			System.out.print(root.data);
			if (root.left != null)
			{
				System.out.print("L->[");
				printTreeNice(root.left);
				System.out.print("]");
			}
			if (root.right != null)
			{
				System.out.print("R->[");
				printTreeNice(root.right);
				System.out.print("]");
			}
		}

	}



}
