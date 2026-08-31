package data_structure.tree.online.lca.latest;

import java.util.List;

public class LCABT1 {

    public static void main(String[] args) {

    }



   // O(n)   space O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || p == root || q == root) return root;
         TreeNode left = lowestCommonAncestor(root.left , p,q);
         TreeNode right = lowestCommonAncestor(root.right,p,q);
         if(left != null && right != null) return root;
         return  left != null ? left : right;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, List<TreeNode> childrens) {
        if(childrens == null || childrens.isEmpty()) return null;
        TreeNode lca = childrens.get(0);
        for (TreeNode child : childrens){
            lca = lowestCommonAncestor(root,lca,child);
        }
        return lca;
    }




}
