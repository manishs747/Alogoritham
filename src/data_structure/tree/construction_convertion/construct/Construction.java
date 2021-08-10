package data_structure.tree.construction_convertion.construct;

import data_structure.linklist.online.ListNode;
import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.online.TreeNode;

import java.util.*;

/*
  https://www.geeksforgeeks.org/binary-tree-data-structure/#construction
 */
public class Construction {

    public static void main(String[] args) {
        int[] inorder = {1, 2, 3, 4, 5, 6, 7};
        int[] preorder = {4, 2, 1, 3, 6, 5, 7};
        int[] postOrder = {1, 3, 2, 5, 7, 6, 4};
        int[] sorted = {-10, -3, 0, 5, 9};
        postIndex = postOrder.length - 1;
        Node root = bstFromPreorderNew( preorder);
        BTreePrinter.printNode(root);
    }


    /**************************************BST FROM Preorder**********************************************************************************/
    public static Node bstFromPreorderNew(int[] preorder) {
       return bstFromPreorderNewNode(preorder,Integer.MAX_VALUE);
    }

    static int i = 0;
    public static Node bstFromPreorderNewNode(int[] preorder,int bound){
        if(i >= preorder.length || preorder[i] > bound){
            return null;
        }
        Node node = new Node(preorder[i++]);
        node.left = bstFromPreorderNewNode(preorder,node.data);
        node.right = bstFromPreorderNewNode(preorder,bound);
        return node;
    }




    /**************************************BST FROM PREORDER AND INORDER**********************************************************************************/
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    //https://www.youtube.com/watch?v=GeltTz3Z1rw
    public static Node buildTreeInorderPreOrder(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreePreInOrder(inorderMap, preorder, 0, inorder.length - 1);
    }

    public static int preIndex = 0;

    public static Node buildTreePreInOrder(Map<Integer, Integer> inorderMap, int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preorder[preIndex++]);
        if (start == end) {
            return node;
        }
        node.left = buildTreePreInOrder(inorderMap, preorder, start, inorderMap.get(node.data) - 1);
        node.right = buildTreePreInOrder(inorderMap, preorder, inorderMap.get(node.data) + 1, end);
        return node;
    }


    /**************************************BST FROM POSTORDER AND INORDER***********************************************************************/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreePostInOrder(inorderMap, postorder, 0, inorder.length - 1);
    }

    public static int postIndex = 0;

    public static TreeNode buildTreePostInOrder(Map<Integer, Integer> inorderMap, int[] postOrder, int start, int end) {
        if (start > end || postIndex < 0) {
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postIndex]);
        postIndex = postIndex - 1;
        node.right = buildTreePostInOrder(inorderMap, postOrder, inorderMap.get(node.val) + 1, end);
        node.left = buildTreePostInOrder(inorderMap, postOrder, start, inorderMap.get(node.val) - 1);
        return node;
    }


    /**************************************BST FROM BalancedTreeFromSortedArr*****************************************************************/
    public Node sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return buildBalancedTreeFromSortedArr(list, 0, list.size() - 1);
    }


    public static Node buildBalancedTreeFromSortedArr(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = (start + end) / 2;
        Node node = new Node(sortedList.get(index));
        if (start == end) {
            return node;
        }
        node.left = buildBalancedTreeFromSortedArr(sortedList, start, index - 1);
        node.right = buildBalancedTreeFromSortedArr(sortedList, index + 1, end);
        return node;
    }



    static Node buildTreeFromPreInOrder(int[] preorder, int[] inorder) {

        return buildTreeFromPreInOrderHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static Node buildTreeFromPreInOrderHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int currentRoot = preorder[preStart];
        Node root = new Node(currentRoot);


        return root;
    }

    /*
       https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
       https://www.youtube.com/watch?v=12omz-VAyRk
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }


}
