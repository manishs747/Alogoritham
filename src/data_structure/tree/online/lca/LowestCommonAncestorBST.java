package data_structure.tree.online.lca;

import data_structure.tree.Node;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {

    }


    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node less = p.data < q.data ? p:q , more =    p.data > q.data ? p : q;
        if(root.data > more.data){
            return lowestCommonAncestor(root.left,p,q);
        } else if (root.data < less.data) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }


    public Node lowestCommonAncestorBT(Node root, Node p, Node q) {
        if(root == null || p == root || q == root) return root;
        Node left = lowestCommonAncestorBT(root.left,p,q);
        Node right = lowestCommonAncestorBT(root.right,p,q);
        if(left != null && right != null) return  root;
        return left != null ? left : right;
    }
}
