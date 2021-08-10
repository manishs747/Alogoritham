package data_structure.linklist;

import data_structure.linklist.online.ListNode;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {-1,5,3,4,0};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(insertionSortList(node));

    }


    public static Node insertionSortList(Node head) {
        Node Rental = new Node(Integer.MIN_VALUE);
        while (head != null){
            Node current = Rental;
            while (current.next != null && current.next.data < head.data){
                current = current.next;
            }
            Node next = current.next;
            current.next = head;
            head = head.next;
            current.next.next = next;
        }
        return  Rental.next;
    }



    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            ListNode prev = dummy;
            // find the position to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            ListNode next = curr.next;
            // insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;
            // moving on to the next iteration
            curr = next;
        }
        return dummy.next;
    }




}
