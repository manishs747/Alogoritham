package data_structure.tree.construction_convertion;

import data_structure.tree.Node;
import data_structure.tree.online.TreeNode;

/*
  https://www.geeksforgeeks.org/binary-tree-data-structure/#construction
 */
public class Construction {

    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    //https://www.youtube.com/watch?v=GeltTz3Z1rw
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {


        return null;
    }


    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    public TreeNode buildTreeInPost(int[] inorder, int[] postorder) {


        return null;
    }

    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return null;
    }


    /*
    https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
     */
    public TreeNode bstFromPreorder(int[] preorder) {


        return null;
    }


    static Node buildTreeFromPreInOrder(int[] preorder, int[] inorder) {

        return buildTreeFromPreInOrderHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static Node buildTreeFromPreInOrderHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int currentRoot = preorder[preStart];
        Node root = new Node(currentRoot);


        return root;
    }

    /*
       https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
       https://www.youtube.com/watch?v=12omz-VAyRk
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }



}
