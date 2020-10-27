package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestSum {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        int sum  = deepestLeavesSum(null);
        System.out.print(sum);
    }


    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(null);
        return deepestLeavesSumHelper(list);
    }

    public static int deepestLeavesSumHelper(Queue<TreeNode> list) {
        int  sum = 0;
        while (!list.isEmpty()) {
            TreeNode node = list.remove();
            if (null == node && list.isEmpty()) {
                return sum;
            }
            if (null == node) {
                list.add(null);
                sum = 0;
                continue;
            }
            sum += node.val;
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
        }
        return sum;
    }
}
