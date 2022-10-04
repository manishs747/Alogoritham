package data_structure.tree.online;

/**
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 */
public class EvaluateTree {

    public static void main(String[] args) {

    }

    public boolean evaluateTree(TreeNode root) {
       if(root.left == null && root.right == null) return root.val == 0 ? false : true;
       return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
