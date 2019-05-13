package Tree;

public class Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = Tree.getSampleBinarySearchTree();
		 //TreeUtility.printNice(root);
		
	}
	
	
	
	public static boolean areMirror(NodeT node1, NodeT node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		
		if(node1.data != node2.data ){
			return false;
		}else{
			return areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);
		}
	}
	

	
	//code to make mirror of it self
	public static void mirror(NodeT node){
		if(node == null){
			return;
		}
		mirror(node.left);
		mirror(node.right);
		swapNode(node);
	}



	private static void swapNode(NodeT node) {
		NodeT temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}
