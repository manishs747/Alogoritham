package Tree;


//INSERT  DELETE

public class BasicOperation {
	
   // Root of BST 
  //  Node root;
    
    public static void main(String[] args) {
    	Node root = new Node(4);
    	int [] arr = {2,1,6,5,7,8};
    	for (int i : arr) {
    		root = insert(root,i);
		}
        BTreePrinter.printNode(root);
        root = deletion(root, 6);
       BTreePrinter.printNode(root);
	}

    public static Node insert(Node root,int data) {
    	if (root  == null) {
    		return root;
    	}
    	if (data < root.data) {
    		if( root.left == null) {
    			root.left = new Node(data);
    		}else {
    			insert(root.left, data);
    		}
    	}
    	else {
    		if( root.right == null) {
    			root.right = new Node(data);
    		}else {
    			insert(root.right, data);
    		}
    	}
    	return root;
    }
    
    public static Node insertRec(Node root,int data) {
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data) 
            root.left = insertRec(root.left, data); 
        else if (data > root.data) 
            root.right = insertRec(root.right, data); 
        return root; 
    }
    
    
    /* function to delete element in binary tree */
    public static Node deletion(Node root, int value) {
    	if (root == null) {
    		return root;
    	}
    	if(value < root.data) { //go lkeft
    		root.left = deletion(root.left, value);
    	}else if (value > root.data) {
    		root.right = deletion(root.right, value);
    	}
    	if (value == root.data) {
    		// Cases 1 and 2: node to delete has 0 or 1 child(ren)
    		if (root.left == null ) {  
    			return root.right; //return deletion(root.right, value); 
    		}
    		if (root.right == null ) {
    			return root.left;  //	return deletion(root.left, value);
    		}
    		// Case 3: node to delete has 2 children
            // Replace the value in the subtreeRoot node with the smallest value from the right subtree
    		root.data = root.right.min().data;
    		root.right = deletion(root.right, root.data);
    		
    	}
    	return root;
    }
    

	

	
	
   
     
    
	
	
	

}
