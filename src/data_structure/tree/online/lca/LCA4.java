package data_structure.tree.online.lca;

import data_structure.tree.online.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LCA4 {

    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode>  set = getNodeSet(nodes);
        return lowestCommonAncestor(root,set);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> nodes) {
        if(root == null || nodes.contains(root)) return root;
        TreeNode left = lowestCommonAncestor(root.left,nodes);
        TreeNode right = lowestCommonAncestor(root.right,nodes);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    public Set<TreeNode> getNodeSet(TreeNode[] nodes){
        Set<TreeNode>  set = new HashSet<>();
        for (TreeNode node:nodes){
            set.add(node);
        }
        return set;
    }
}
