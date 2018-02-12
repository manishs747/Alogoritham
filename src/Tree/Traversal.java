package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Node root = TreeUtility.getSampleTree();
		// TreeUtility.printNice(node);
		// BTreePrinter.printNode(root);
		 
		// printInOrder(root);
		 System.out.println();
		// printPreOrder(node);
		// printPostOrder(node);
		 printLevelOrder(root);
		 System.out.println();
		 levelOrderTraversalReverse(root);
	}
	
	
	
	
	public static void printInOrder(Node node) {
		if(node==null){return;}
		printInOrder(node.left);
		System.out.print( node.data  + " ");
		printInOrder(node.right);
	}
	
	public static void printInOrderIterative(Node node) {
		if(node==null){return;}
	
		System.out.print( node.data  + " ");
		
	}
	
	public static void printPreOrder(Node node) {
		if(node==null){return;}
		System.out.print( node.data  + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public static void printPostOrder(Node node) {
		if(node==null){return;}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(  node.data  + " ");
	}
	
	
	public static void  printVerticalOrder(Node root){
		Map<Integer,ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		getVerticalOrder(root, 0, map);
		  
		 Set<Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
		 for (Entry<Integer, ArrayList<Integer>> entry : set) {
			System.out.println(entry.getValue());
		  }
	}
	public static void getVerticalOrder(Node node,int hd ,Map<Integer,ArrayList<Integer>> map){
		if(node==null){
			return;
		}
		if(map.containsKey(hd)){
			 map.get(hd).add(node.data);
		}else{
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 list.add(node.data);
			 map.put(hd, list);
		}
		
		//left iteration
		getVerticalOrder(node.left, hd-1, map);
		
		//right iteration
		getVerticalOrder(node.right, hd+1, map);
		
	}
	
	
	//bfs
	public static void printLevelOrder(Node node) {
		if(node==null){return;}
		Queue<Node> queue = new LinkedList<Node>();	
		queue.add(node);
		while(!queue.isEmpty()){
			  Node tempNode = queue.poll();
	          System.out.print(tempNode.data + " ");
	          /*Enqueue left child */
	          if(tempNode.left != null){
	        	  queue.add(tempNode.left);
	          }
	          
	          /*Enqueue right child */
	          if(tempNode.right!=null){
	        	  queue.add(tempNode.right);
	          }
			 
		}
	}
	
	public static void levelOrderTraversalReverse(Node root){
		if(root==null){return;}
		Queue<Node> queue = new LinkedList<Node>();	
		Stack<Node> stack = new Stack<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			stack.push(temp);
			if(temp.right != null){
				queue.add(temp.right);
			}
			if(temp.left != null){
				queue.add(temp.left);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().data+" ");
		}
	}

}
