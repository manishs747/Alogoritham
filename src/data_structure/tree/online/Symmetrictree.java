package data_structure.tree.online;


/**
 * https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class Symmetrictree {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left , TreeNode right) {
           if(left == null && right == null) return true;
           if(left == null || right == null || left.val != right.val) return false;
           return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

}
