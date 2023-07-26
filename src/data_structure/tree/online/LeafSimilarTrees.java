package data_structure.tree.online;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {

    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        setLeaveSequence(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        setLeaveSequence(root2,list2);
        return list1.equals(list2);
    }

    public static void setLeaveSequence(TreeNode root, List<Integer> list){
        if(root == null) return;
        setLeaveSequence(root.left,list);
        if ( null == root.left && null == root.right )
            list.add(root.val);
        setLeaveSequence(root.right,list);
    }



}
