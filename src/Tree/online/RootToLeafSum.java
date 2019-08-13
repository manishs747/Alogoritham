package Tree.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.Node;

public class RootToLeafSum {

	public int sumRootToLeaf(TreeNode root) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		getRootToLeafNodes(root, stack, list);
		int sum = 0;
		for (int val : list) {
			sum += val;
		}
		 return sum;
	}

	private void getRootToLeafNodes(TreeNode root, Stack<Integer> stack, List<Integer> list) {
		if (root == null) {
			return ;
		}
		stack.push(root.val);
		// System.out.println(stack);
		if (root.left == null && root.right == null) {
			list.add(setFromStack(stack));
		}
		getRootToLeafNodes(root.left, stack, list);
		getRootToLeafNodes(root.right, stack, list);
		stack.pop();
		
	}

	private int setFromStack(Stack<Integer> stack) {
		Stack<Integer> tmp = new Stack<>();
		while (!stack.isEmpty()) {
			tmp.push(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (!tmp.isEmpty()) {
			int val = tmp.pop();
			sb.append(val);
			stack.push(val);
		}
		return Integer.parseInt(sb.toString(), 2);
	}

}
