package data_structure.tree.view;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;
import data_structure.tree.online.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/****
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    public static void main(String[] args) {
        /*Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        System.out.println(rightSideView(root));*/
    }

    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }

/****************************************BFS*********************************************************************/
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode>  queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode prev = null;
        while (!queue.isEmpty()){
            TreeNode current = queue.pop();
         if(current == null){
             result.add(prev.val);
             if(queue.isEmpty()) break;
             queue.add(null);
             continue;
         }
         prev = current;
         if(current.left != null) queue.add(current.left);
         if(current.right != null) queue.add(current.right);
        }
        return result;
    }
}
