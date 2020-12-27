package data_structure.tree.online;


import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class LCA {

    public static void main(String[] args) {

        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
       // System.out.println(lowestCommonAncestor(root,new Node(1),new Node(7)));
    }


    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     *
     */

    public TreeNode  lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if((root.val < p.val && root.val > q.val ) || (root.val < q.val && root.val > p.val ) ){
            return root;
        }
        if(root.val == p.val){
           return p;
        }
        if(root.val == q.val){
            return q;
        }
        if(p.val < root.val){
           return lowestCommonAncestor(root.left,p,q);
        }
        return lowestCommonAncestor(root.right,p,q);
    }
}
