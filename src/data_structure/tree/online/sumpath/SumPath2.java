package data_structure.tree.online.sumpath;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;
import data_structure.tree.online.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *  https://leetcode.com/problems/path-sum-ii/
 */
public class SumPath2 {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left.right.data = 9;
        BTreePrinter.printNode(root);
        System.out.println(hasPathSum2(root, 15));
     /*   Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(getListFromStack(stack));
        System.out.println(stack);*/


    }


    public static List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        hasPathSum(root, sum, list, new Stack<>());
        return list;
    }

    public static void hasPathSum(TreeNode root, int sum, List<List<Integer>> list, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        stack.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> pathList = new ArrayList<>();
            stack.stream().forEach(s -> pathList.add(s));
            list.add(pathList);
        }
        hasPathSum(root.left, sum - root.val, list, stack);
        hasPathSum(root.right, sum - root.val, list, stack);
        stack.pop();
    }

    public static List<List<Integer>> hasPathSum2(Node root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        hasPathSum2(root, targetSum, list, new LinkedList<>());
        return list;
    }

    public static void hasPathSum2(Node root, int sum, List<List<Integer>> list, LinkedList<Integer> path) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null && root.data == sum) {
            list.add(new ArrayList<>(path));
        }
        hasPathSum2(root.left, sum - root.data, list, path);
        hasPathSum2(root.right, sum - root.data, list, path);
        path.removeLast();
    }


}
