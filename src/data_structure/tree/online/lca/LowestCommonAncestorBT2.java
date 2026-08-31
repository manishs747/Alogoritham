package data_structure.tree.online.lca;


import data_structure.tree.Node;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/editorial/
 *
 * node might not be present in tree
 */
public class LowestCommonAncestorBT2 {

    public static void main(String[] args) {

    }


    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node lca = lcaHelper(root,p,q);
        if(lca == p && isChildPresent(p,q)){
            return p;
        }
        if(lca == q && isChildPresent(q,p)){
            return q;
        }
        return lca;
    }

     public  Node lcaHelper(Node root, Node p,Node q) {
        if(root == null || root == p || root == q) return root;
        Node left = lcaHelper(root.left,p,q);
        Node right = lcaHelper(root.right,p,q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
     }


     public  boolean isChildPresent(Node root , Node child){
        if(root == null) return false;
        if(root == child) return true;
        return isChildPresent(root.left,child) || isChildPresent(root.right,child);
    }

}
