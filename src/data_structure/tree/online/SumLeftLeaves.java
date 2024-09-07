package data_structure.tree.online;


/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/?envType=daily-question&envId=2024-04-14
 */
public class SumLeftLeaves {

    public static void main(String[] args) {

    }


    public int sumOfLeftLeaves(TreeNode root) {
           if(root == null) return 0;
           int sum = (root.left != null && root.left.left == null && root.left.right == null) ?root.left.val:0;
           return sum + sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

}
