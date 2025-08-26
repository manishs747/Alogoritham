package data_structure.tree.online;


/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/description/?envType=daily-question&envId=2024-09-07
 */
public class LinkedListBinaryTree {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {

    }


    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root == null) return false;
            if(dfsSubpath(head,root)) return true;
            return isSubPath(head,root.left) || isSubPath(head,root.right);
        }
    }

    private boolean dfsSubpath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null || root.val != head.val) return false;
        return dfsSubpath(head.next,root.left) || dfsSubpath(head.next,root.right);
    }


}
