package algorithams.backtracking.online;


import data_structure.tree.TreeUtility;
import data_structure.tree.online.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=backtracking
 */
public class BinarytreePaths {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root,res,new ArrayList<>());
        return res;
    }

    public static void binaryTreePaths(TreeNode root,List<String> result,List<Integer> sb) {
         if(root == null) return ;
         sb.add(root.val);
         if(root.left == null && root.right == null)
             result.add(convert(sb));
         binaryTreePaths(root.left,result,sb);
         binaryTreePaths(root.right,result,sb);
         sb.remove(sb.size()-1);
    }

    public static String convert(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i :list)
            sb.append(i+"->");
        return sb.toString().substring(0,sb.length()-2);
    }

}
