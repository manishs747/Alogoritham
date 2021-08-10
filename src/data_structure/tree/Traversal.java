package data_structure.tree;

import java.util.*;
import java.util.Map.Entry;

/*
 * https://www.geeksforgeeks.org/binary-tree-data-structure/
 * 
 * 
 * 
 */
public class Traversal {

	public static void main(String[] args) {
		 Node root = TreeUtility.getSampleBinarySearchTree();
		 BTreePrinter.printNode(root);
		 printPostOrder(root);
	}
	

	private static void printInOrder(Node node) {
		if(node==null){return;}
		printInOrder(node.left);
		System.out.print( node.data  + " ");
		printInOrder(node.right);
	}
	
	public static void printInOrderIterative(Node root) {
		if(root==null){return;}
		Stack<Node> stack = new Stack<Node>();
		while(true){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			System.out.print( root.data  + " ");
			root = root.right;
		}
	}
	
	

	

	
	public static void printPostOrder(Node node) {
		if(node==null){return;}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(  node.data  + " ");
	}
	
	
	
	public static void printPostOrderIterativeTwoStack(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty()){
			Node tmp = s1.pop();
			s2.push(tmp);
			if(tmp.left != null){
				s1.push(tmp.left);
			}
			if(tmp.right != null){
				s1.push(tmp.right);
			}
		}
		while(!s2.isEmpty()){
			System.out.print(s2.pop().data+" ");
		}
	}
	
	
	//lovely solution 
	/*
	 * The idea is to move down to leftmost node using left pointer. While moving down, push root and root’s right child to stack. Once we reach leftmost node, 
	 * print it if it doesn’t have a right child. If it has a right child, then change root so that the right child is processed before.
	 */
	public static void printPostOrderIterativeSingleStack(Node root) {
		if(root==null){return;}
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			while(current != null){
				if(current.right != null){
					stack.push(current.right);
				}
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()){
				break;
			}
			current = stack.pop();
			if(current.right != null && !stack.empty()  && current.right == stack.peek()){
				stack.pop();
				stack.push(current);
				current = current.right;
			}else{
				System.out.print( current.data  + " ");
				current = null;
			}

		}
	}
	
	
	
	public static void printPostOrderIterative(Node root) {
		if(root==null){
			return;}
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(root.right != null){
				stack.add(root.right);
			}
			stack.add(root);
			
			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			if(root.right == null){
				System.out.print(root.data + " ");
				root = root.right;
			}else if(!stack.isEmpty() && root.right == stack.peek()){
				Node tmp = stack.pop();
				stack.push(root);
				root = tmp;
			}else if(!stack.isEmpty() && root.right != stack.peek()){
				Node tmp = stack.pop();
				System.out.print(tmp.data + " ");
				if(!stack.isEmpty()){
					tmp = stack.pop();
					root = tmp.right;
					stack.push(tmp);
				}
				root = root.right;
			}
		}
	}
	
	public static void  printVerticalOrder(Node root){
		Map<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();

		getVerticalOrder(root, 0, map);
		  
		 Set<Entry<Integer, List<Integer>>> set = map.entrySet();
		 for (Entry<Integer, List<Integer>> entry : set) {
			System.out.println(entry.getValue());
		  }
	}
	public static void getVerticalOrder(Node node, int hd , Map<Integer,List<Integer>> map){
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
	
	
	//https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
		/*
		      1
	        /    \
	       2      3
	      / \    / \
	     4   5  6   7
	             \   \
	              8   9
	              
	              4
						4
						2
						1 5 6
						3 8
						7
						9 
							 */
		static void printVerticalOrderLevelOrder(Node root){
	      if(root == null){
	    	  return;
	      }
	      Map<Integer,List<Integer>> map = new TreeMap<>();
	      printVerticalOrderLevelOrderTraversalUtil(root,0,map);
	      Set<Entry<Integer, List<Integer>>> set = map.entrySet();
			 for (Entry<Integer, List<Integer>> entry : set) {
				System.out.println(entry.getValue());
			  }
		}
		
		static void printVerticalOrderLevelOrderTraversalUtil(Node root, int hd, Map<Integer,List<Integer>> map){
			if(root == null){
				return;
			}
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			while(!queue.isEmpty()){
				root = queue.poll();
				if(root == null){
					hd++;
					if(!queue.isEmpty()){
						queue.add(null);
					}
				}else{
					List<Integer> list;
					if(!map.containsKey(hd)){
						list = new ArrayList<>();
						list.add(root.data);
						map.put(hd, list);
					}else{
						list = map.get(hd);
						list.add(root.data);
						map.put(hd, list);
					}
					if(root.left != null){
						queue.add(root.left);
					}
					if(root.right != null){
						queue.add(root.right);
					}

				}
			}
		}

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
	 public  static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node A) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 if(A == null) {
			 return result;
		 }
		 boolean asc = false;
		 Queue<Node> queue = new LinkedList<>();
		 queue.add(A);
		 queue.add(null);
		 ArrayList<Integer> list = new ArrayList<>();
		 while(!queue.isEmpty()) {

			Node node = queue.poll();
			if(queue.isEmpty()){
				if(asc){
					Collections.reverse(list);
				}
				result.add(list);
				break;
			 }
			if(node == null) {
				if(asc){
					Collections.reverse(list);
				}
				queue.add(null);
				result.add(list);
				list = new ArrayList<>();
				asc = !asc;
				continue;
			}
			list.add(node.data);
			 if(node.left != null){
				 queue.add(node.left);
			 }
			 if(node.right != null){
				 queue.add(node.right);
			 }
		 }
		return result;
	 }


	
	
	// Print diagonal traversal of given binary datastructure.strings.datastructure.strings.tree
	//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
	static void diagonalPrint(Node root){
		if(root == null){
			return;
		}
		
		 Map<Integer,List<Integer>> map = new LinkedHashMap<>();
		 diagonalPrintutil(root,0,0,map);
	      Set<Entry<Integer, List<Integer>>> set = map.entrySet();
			 for (Entry<Integer, List<Integer>> entry : set) {
				System.out.println(entry.getValue());
			  }

	}
	
	static void diagonalPrintutil(Node root, int l , int hd, Map<Integer,List<Integer>> map){
		if(root == null){
			return;
		}
		int diagonalKey = l - hd;
		List<Integer> list;
		if(!map.containsKey(diagonalKey)){
			list = new ArrayList<Integer>();
		}else{
			list = map.get(diagonalKey);
		}
		list.add(root.data);
		map.put(diagonalKey, list);
		diagonalPrintutil(root.left, l+1, hd -1 , map);
		diagonalPrintutil(root.right, l+1, hd + 1, map);
		
	}
	
	
	//lovely solution
	static void printPathsRecur(Node root){
		Stack<Integer> path = new Stack<Integer>();
		printPathsRecur(root,path);
	}
	
	static void printPathsRecur(Node root , Stack<Integer> path) {
		if(root == null){
			return;
		}
		path.push(root.data);
		if(root.left == null && root.right == null){
			System.out.println(path);
		}
		
		printPathsRecur(root.left, path);
		printPathsRecur(root.right, path);
		path.pop();
	}
	
	
	static void printKDistant(Node root, int k) {
		if(root == null){
			return;
		}
		if(k==0){
			System.out.println(root.data);
			return;
		}
		printKDistant(root.left, k-1);
		printKDistant(root.right, k-1);
	}
	
	
	
	static void boundaryTraversal(Node root){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
