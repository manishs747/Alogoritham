package data_structure.tree.traversal;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    public static void main(String[] args) {

        Node root = TreeUtility.getSampleBinarySearchTree();
      /*  root.left.right = null;
        root.left.left = null;
        root.right.right = null;*/
        BTreePrinter.printNode(root);
       printInOrderIterative(root);
    }

    private static void printInOrder(Node root) {
        if(root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    private static void printInOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            if(root == null && stack.isEmpty()){
                break;
            }
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }


    private static Node cur;
    public static Node increasingBSTMemory(Node root) {
        Node ans = new Node(0);
        cur = ans;
        increasingBSTMemoryhelper(root);
        return ans.right;
    }

    public static void increasingBSTMemoryhelper(Node root) {
        if(root == null) {
            return ;
        }
        increasingBSTMemoryhelper(root.left);
        root.left =  null;
        cur.right = root;
        cur = root;
        increasingBSTMemoryhelper(root.right);
    }

    /**
     * https://leetcode.com/problems/increasing-order-search-tree/solution/
     *  100/48
     * @param root
     * @return
     */
    public static Node increasingBST(Node root) {
        if(null == root){
            return null;
        }
        List<Node> list = new ArrayList<>();
        getInorder(root, list);
        Node prev = list.get(0);
        for (int i = 1;i < list.size();i++) {
            Node current = list.get(i);
            prev.right = current;
            prev.left = null;
            prev = current;
        }
        Node last = list.get(list.size()-1);
        last.left =  null;
        last.right = null;
        return list.get(0);
    }

    public  static void getInorder(Node root , List<Node> list) {
        if(root == null) {
            return;
        }
        getInorder(root.left, list);
        list.add(root);
        getInorder(root.right, list);
    }


   /*
   https://leetcode.com/problems/minimum-absolute-difference-in-bst/
   https://leetcode.com/problems/minimum-distance-between-bst-nodes/
    */
   int prev = Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;

    public int minDiffInBST(Node root) {
        inorder(root);
        return diff;
    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        diff = Math.min(Math.abs( root.data - prev), diff);
        prev =  root.data;
        inorder(root.right);
    }





}
