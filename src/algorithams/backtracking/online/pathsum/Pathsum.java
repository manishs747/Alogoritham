package algorithams.backtracking.online.pathsum;

import data_structure.tree.online.TreeNode;

public class Pathsum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if( root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }


  /*  public boolean haspathhelper(TreeNode root, int targetSum) {
        if(root==null && targetSum==0) return true;
        if (root == null || targetSum<0) return false;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }*/

}
