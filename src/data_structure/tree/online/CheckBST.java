package data_structure.tree.online;

import data_structure.tree.Node;
import data_structure.tree.NodeT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

https://www.youtube.com/watch?v=i_Q0v_Ct5lY
https://leetcode.com/problems/validate-binary-search-tree/

 */
public class CheckBST {

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


    public static boolean checkBSTWithArray(NodeT node) {
        List<Integer> list = new ArrayList<>();
        checkBSTWithArrayInorder(node, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void checkBSTWithArrayInorder(NodeT<Integer> node,
                                                List<Integer> list) {
        if (node == null) {
            return;
        }
        checkBSTWithArrayInorder(node.left, list);
        list.add(node.data);
        checkBSTWithArrayInorder(node.right, list);
    }

    public static int temp = Integer.MIN_VALUE;


    //best solution
    public static boolean checkBSTInorder(Node node) {
        if (node == null) {
            return true;
        }
        boolean state = checkBSTInorder(node.left);
        if (state == false) {
            return false;
        }
        if (node.data > temp) {
            temp = node.data;
        } else {
            return false;
        }
        return checkBSTInorder(node.right);
    }




}
