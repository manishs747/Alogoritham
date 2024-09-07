package data_structure.tree.online;


/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17
 */
public class DeleteLeaveValue {

    public static void main(String[] args) {

    }


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode leftchild = removeLeafNodes(root.left,target);
        TreeNode rightchild = removeLeafNodes(root.right,target);
        if(leftchild == null && rightchild ==  null && root.val == target) return null;
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

}
