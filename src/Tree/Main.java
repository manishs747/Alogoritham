package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int [] list = {4,2,6,1,3,5,7};
		Node root = Tree.getBSTFromArray(list);
		BTreePrinter.printNode(root);
		ReversezigzagLevelOrder(root);
	}
	
	
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
	
	
	public static void levelOrder(Node root) {
		if(root == null){
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();	
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if (n == null) {
				if (queue.isEmpty()) {
					break;
				}
				System.out.println();
				queue.add(null);
			} else {
				System.out.print(n.data+" ");
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}

	}





}
