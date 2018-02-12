package Tree;

public class TreeOperation {
	
	

	
	public static  void insert(Node node, int value) {
		if (node == null) {
			return;
		}
		if (node.data > value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else if (node.data < value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				
				node.right = new Node(value);
			}
		}
	}
	
	//insert tree in binary tree structure  //wrong not handled empty case
	public static NodeT<Integer> insertNode(NodeT<Integer> node, int value) {
		if (node == null) {
			node = new NodeT<Integer>(value);
			return node;
		}
		if (node.getData() >= value) {
			node.left = insertNode(node.left, value);
		} else if (node.getData() < value) {
			node.right = insertNode(node.right, value);
		}
		return node;
	}
	
	

	//finds a node in tree
	public static <T> NodeT<Integer> find(NodeT<Integer> current, int value) {
		if (current == null || current.getData() == value)
			return null;
		if (current.getData() == value)
			return current;
		if (current.getData() > value)
			return find(current.left, value);

		return find(current.right, value);
	}
	
	public boolean contains(Node root ,int value){
		if( root.data == value){
			return true;
		}
		else if(value < root.data){
			if(root.left == null){
				return false;
			} else{
				return contains(root.left, value);
			}

		}else{
			if(root.right == null){
				return false;
			} else{
				return contains(root.right, value);
			}
		}
	}
	

	
	
   
     
    
	
	
	

}
