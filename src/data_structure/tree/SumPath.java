package data_structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumPath {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left.left.right = new Node(8);
        // TreeUtility.printNice(node);
        BTreePrinter.printNode(root);
        printRootToLeafPath(root);
    }



    public static void printRootToLeafPath(Node root) {
        Stack<Node> stack = new Stack<Node>();
        List<List<Integer>> result = new ArrayList<>();
        printRootToLeafPathRec(root,stack,9,result);
        System.out.println(result);
    }



    private static void printRootToLeafPathRec(Node root, Stack<Node> stack , int target, List<List<Integer>> list) {
        if(root==null){
            return;
        }
        stack.push(root);

        printRootToLeafPathRec(root.left,stack,target,list);
        printRootToLeafPathRec(root.right,stack,target,list);

        if(root.left == null && root.right == null  ){
            List<Integer> st = new ArrayList();
            int sum = 0;
            for (Node node :stack) {
                 sum = sum + node.data;
                 st.add(node.data);
            }
            if(sum == target){
                list.add(st);
            }

        }
        stack.pop();
    }
}
