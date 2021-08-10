package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

public class MergeTwoSortedList {

    class SinglyLinkedListNode {
          int data;
         SinglyLinkedListNode next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {

        Node list1 =  new Node(1,new Node(3,new Node(5)));
        ListUtility.Print(list1);
        Node list2 =  new Node(2,new Node(4,new Node(6)));
        ListUtility.Print(list2);
        ListUtility.Print( mergeLists(list1,list2));
    }


    static Node mergeLists(Node head1, Node head2) {
        if (head1 == null) { return head2; }
        if (head2 == null) { return head1; }
        Node head3;
        if (head1.data <= head2.data) {
            head3 = head1;
            head1 = head1.next;
        } else {
            head3 = head2;
            head2 = head2.next;
        }
        Node current = head3;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 == null) {
            current.next = head2;
        } else {
            current.next = head1;
        }

        return head3;
    }

    /*
    https://leetcode.com/problems/merge-two-sorted-lists/
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        ListNode head3 = null;
        if (l1.val <= l2.val) {
            head3 = l1;
            l1 = l1.next;
        } else {
            head3 = l2;
            l2 = l2.next;
        }
        ListNode current = head3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return head3;
    }


    /*
    https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) { return head2; }
        if (head2 == null) { return head1; }
        SinglyLinkedListNode head3 = null;
        if (head1.data <= head2.data) {
            head3 = head1;
            head1 = head1.next;
        } else {
            head3 = head2;
            head2 = head2.next;
        }
        SinglyLinkedListNode current = head3;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 == null) {
            current.next = head2;
        } else {
            current.next = head1;
        }

        return head3;
    }


}
