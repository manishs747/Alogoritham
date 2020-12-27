package data_structure.tree;

public class ChildSum {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleTree();
		root.data = 4;
		root.left.data = 2;
		root.left.right.data = 5;
		root.left.left.data = 3;

		root.right.data = 9;
		root.right.right.data = 7;
		root.right.left = null;

        BTreePrinter.printNode(root);
		System.out.println(findTilt(root));

    }


    public static int makeSum(Node root) {
        if (root == null)
            return 0;
        int sum = makeSum(root.left) + makeSum(root.right);
        if (root.left != null || root.right != null)
            root.data = sum;
        return root.data + sum;
    }


	/**
	 * https://leetcode.com/problems/binary-tree-tilt/
	 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values
	 * nd all right subtree node values. If a node does not have a left child,
	 * then the sum of the left subtree node values is treated as 0.
	 * The rule is similar if there the node does not have a right child.
	 * @param root
	 * @return
	 */

	public static int sum = 0;
	public static int findTilt(Node root) {
		fintTiltHelper(root);
		return sum;
	}

	private static int fintTiltHelper(Node root) {
		if (root == null)
			return 0;
		int ls = fintTiltHelper(root.left);
		int rs =  fintTiltHelper(root.right);
		sum += Math.abs(ls-rs);
		return root.data + ls + rs;
	}

}
