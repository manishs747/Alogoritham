package data_structure.tree.online;

import data_structure.tree.Node;

import java.util.LinkedList;

/*

https://www.youtube.com/watch?v=i_Q0v_Ct5lY
https://leetcode.com/problems/validate-binary-search-tree/

 */
public class ValidBst {

    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();


    public static void main(String[] args) {

    }


    public boolean isValidBST(Node root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }


    public boolean isValidBST(Node root,int start,int end) {
        if(null == root){
            return true;
        }
        if(root.data <= start || root.data >= end ){
            return false;
        }
        return  isValidBST(root.left,start,root.data) && isValidBST(root.right,root.data,end);
    }




    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long start,long end) {
        if(null == root){
            return true;
        }
        if(root.val <= start || root.val >= end ){
            return false;
        }
        return  isValidBST(root.left,start,root.val) && isValidBST(root.right,root.val,end);
    }


    //iterative
    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBSTIteraive(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }




}
