package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Tree.online.TreeNode;

//bfs
public class Level {

	public static void main(String[] args) {

		int [] list = {};
		Node root = Tree.getBSTFromArray(list);
		BTreePrinter.printNode(root);
		System.out.println(levelOrder(root));

	}
	
	
	/*******************************************************LEVEL ORDER ********************************************************************************/
	
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(queue.isEmpty()) {
                break;
            }
            
            if(node == null) {
                queue.add(null);
                result.add(list);
                list =  new ArrayList<>();
            }else {
                list.add(node.data);
                if(node.left != null) {
                    queue.add(node.left) ;
                }
                if(node.right != null) {
                    queue.add(node.right) ;
                }
            }
        }
        result.add(list);
        return result;
    }
	
	
	/*******************************************************LEVEL ORDER REVERSE********************************************************************************/
	
	public static List<List<Integer>> levelOrderBottom(Node root) {
		if(root == null) {
			return null;
		}
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        Stack<Node> stack = new Stack<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(queue.isEmpty()) {
                break;
            }
            stack.push(node);
            if(node == null) {
                queue.add(null);
            }else {
                if(node.right != null) {
                    queue.add(node.right) ;
                }
                if(node.left != null) {
                    queue.add(node.left) ;
                }
            }
        }
        System.out.println(stack);
        return getListFromStack(stack);
    }

    public static List<List<Integer>> getListFromStack(Stack<Node> stack){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if(node == null) {
                result.add(list);
                list = new ArrayList<Integer>();
            }else {
                list.add(node.data);
            }
        }
        result.add(list);
        return result;
    }

	/*******************************************************LEVEL ORDER********************************************************************************/

	//BFS
	/*
	 *     4       
		  / \   
		 /   \  
		 2   6   
		/ \ / \ 
		1 3 5 7 
         
      4 2 6 1 3 5           

	 */
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
	
	/***************************************************************************************************************************************/

	//print each level in one line
	/*
	 * 
	 *  4 
		2 6 
		1 3 5 7 
	 * 
	 */
	public static void printEachLevelSeperateLine(Node node){
		if(node==null){return;}
		Queue<Node> queue = new LinkedList<Node>();	
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){
			Node current  = queue.poll();
			if(current == null){
				if(queue.isEmpty()){
					break;
				}
				System.out.println();
				queue.add(null);
			}else{
				System.out.print(current.data + " ");
				/*Enqueue left child */
				if(current.left != null){
					queue.add(current.left);
				}
				/*Enqueue right child */
				if(current.right!=null){
					queue.add(current.right);
				}
			}
		}
	}

	/***************************************************************************************************************************************/
	//easy  good
	
	/*
	 * 
	 *  4 
		2 6 
		1 3 5 7 
	 */
	
	public static void printLevelOrderLineTwoQueue(Node node){
		if(node == null){
			return;
		}
		Queue<Node> first = new LinkedList<Node>();	
		Queue<Node> second = new LinkedList<Node>();	
		first.add(node);

		while(!first.isEmpty() || !second.isEmpty()){
			if(first.isEmpty()){
				Queue<Node> tmp = first;
				first = second;
				second = tmp;
			}
			while(!first.isEmpty()){
				Node current = first.poll();
				System.out.print(current.data + " ");
				/*Enqueue left child */
				if(current.left != null){
					second.add(current.left);
				}
				/*Enqueue right child */
				if(current.right!=null){
					second.add(current.right);
				}
			}
			System.out.println();
		}

	}

	/***************************************************************************************************************************************/
	
	//print bottom layer first
	/*
	 * 
	 *     4       
		  / \   
		 /   \  
		 2   6   
		/ \ / \ 
		1 3 5 7 
                
		1 3 5 7 2 6 4 
	 * 
	 */
	public static void levelOrderTraversalReverseLevel(Node root){
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
	
	
	/***************************************************************************************************************************************/
	/* 4       
	  / \   
	 /   \  
	 2   6   
	/ \ / \ 
	1 3 5 7 
	                
	4 
	6 2  
	1 3 5 7   */  //2 stack
	

	public static void printZigZagTraversal(Node root) { 
		Stack<Node> current = new Stack<Node>();
		Stack<Node> next = new Stack<Node>();
		current.push(root);
		boolean leftToRight = true;
		while(!current.isEmpty() ||!next.isEmpty() ) {
			if (current.isEmpty() ) {
				Stack<Node> tmp  = current;
				current = next;
				next = tmp;
				leftToRight = !leftToRight;

			}	
			while(!current.isEmpty()) {
				Node node = current.pop();
				System.out.print(node.data+" ");
				if (leftToRight) {
					if (node.left != null) {
						next.push(node.left);
					}
					if (node.right != null) {
						next.push(node.right);
					}
				} else {
					if (node.right != null) {
						next.push(node.right);
					}
					if (node.left != null) {
						next.push(node.left);
					}
				}

			}
			System.out.println();
		} 
	}
	
	/***************************************************************************************************************************************/
	/*
	   4       
	  / \   
	 /   \  
	2    6   
	/ \ / \ 
	1 3 5 7 
	                
	4 
	6 2  
	1 3 5 7   */  
	 
	
	public static void zigzagLevelOrderSingleQueueStack(Node root) {
		if(root == null){
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();	
		queue.add(root);
		queue.add(null);
		int level = 0;
		Stack<Node> stack = new Stack<>();
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if (n == null) {  //level is chaning
				if (queue.isEmpty()) {
					break;
				}
				if (level % 2 == 1) { //odd level
					while (!stack.isEmpty()) {
						System.out.print(stack.pop().data+" ");
					}
				}
				level++;
				System.out.println();
				queue.add(null);
			} else  {
				if (level % 2 ==  0) { //even
					System.out.print(n.data+" ");
				}else {
					stack.push(n);
				}
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}
	}
	/***************************************************************************************************************************************/
	
	public static void ReversezigzagLevelOrder(Node root) {
		if(root == null){
			return ;
		}
		Stack<Node> stack  = reverseZigZagPrintHelper(root);
		System.out.println(stack);
		boolean reverse = true;
		Stack<Node> reverseStack = new Stack<>();
		while(!stack.isEmpty()) {
			Node node  = stack.pop();
			if (node == null) {
				if (reverse) {
					while(!reverseStack.isEmpty()) {
						System.out.print(reverseStack.pop().data+" ");
					}
				}
				reverse = !reverse;
			}else {
				if (!reverse) {
					System.out.print(node.data+" ");
				}else {
					reverseStack.push(node);
				}
			}
		}
	}


	private static Stack<Node>  reverseZigZagPrintHelper(Node root) {
		Stack<Node> stack = new Stack<>();
		Queue<Node> queue = new LinkedList<Node>();	
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			stack.add(n);
			if (n == null) {
				if (queue.isEmpty()) {
					break;
				}
				queue.add(null);
			} else {
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}
		return stack;
	}
	
	
	
	/***************************************************************************************************************************************/
	
	
	
	
	
	
	
	
	
	
	
	// Iterative method to find every level  minimum element of Binary Tree 
	//https://www.geeksforgeeks.org/smallest-value-level-binary-tree/
	/* Input :  
		            7
		          /    \
		        16       1
		       / \      
		      4   13    
		
		Output :
		Every level minimum is
		level 0 min is = 7
		level 1 min is = 1
		level 2 min is = 4
	 * 
	 */
	void printPerLevelMinimum(Node root) 
	{ 
		
	}

}
