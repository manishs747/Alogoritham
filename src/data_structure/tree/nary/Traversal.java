package data_structure.tree.nary;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
	
	
	public static void main(String[] args) {
		
		System.out.println(preorder(getSampleNode()));
	}
	
	
	public  static Node getSampleNode() {
		
		
		
		Node left31 = new Node(5,null);
		Node left32 = new Node(6,null);
		
		List<Node> list = new ArrayList<>();
		list.add(left31);
		list.add(left32);
		
		Node left21 = new Node(1,list);
		List<Node> list2 = new ArrayList<>();
		list.add(left21);
		
		Node root = new Node(1,list2);
		
		return root;
	}
	

	
	
	  public static  List<Integer> preorder(Node root) {
		  List<Integer> list = new ArrayList<>();
		  preorderHelper(root,list);
		  return list;
	 }
	  
	 public static List<Integer> preorderHelper(Node root,List<Integer> list){
		 
		 if (root == null) {
			 return list;
		 }
		 System.out.println(root.val);
		 list.add(root.val);
		 if(null == root.children) {
			 return list;
		 }
		 for (Node children : root.children) {
			 preorderHelper(children,list);
		 }
		 return list;
	  }

}
