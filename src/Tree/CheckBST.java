package Tree;

import java.util.ArrayList;
import java.util.List;

public class CheckBST {
	/*
	 * Fails For Below Case
	 *  Tree Structure

           3

      2        6

   1     4   5   7
	 * 
	 */
	public static boolean checkBST(NodeT<Integer> node) {
		if (node == null || (node.left == null && node.right == null))
			return true;
		// check bst condtion for current node
		if (node.left != null && node.left.data >= node.data) {
			return false;
		}
		if (node.right != null && node.right.data <= node.data) {
			return false;
		}
		// false if, recursively, the left or right is not a BST */
		if (!checkBST(node.left) || !checkBST(node.right))
			return false;
		return true;
	}
	
	
	public static boolean checkBSTWithArray(NodeT node) {
		List<Integer> list = new ArrayList<>();
		checkBSTWithArrayInorder(node, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void checkBSTWithArrayInorder(NodeT<Integer> node,
			List<Integer> list) {
		if (node == null) {
			return;
		}
		checkBSTWithArrayInorder(node.left, list);
		list.add(node.data);
		checkBSTWithArrayInorder(node.right, list);
	}
	
	public static int temp = Integer.MIN_VALUE;

	
	//best solution
	public static boolean checkBSTInorder(NodeT<Integer> node) {
		if (node == null) {
			return true;
		}
		boolean state = checkBSTInorder(node.left);
		if (state == false) {
			return false;
		}
		if (node.data > temp) {
			temp = node.data;
		} else {
			return false;
		}
		return checkBSTInorder(node.right);
	}
	
	
	
	
	
	

}
