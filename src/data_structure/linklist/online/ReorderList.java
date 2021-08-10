package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        reorderList(node);
        ListUtility.display(node);

    }


    /*
    Given 1->2->3->4, reorder it to 1->4->2->3.
     */
    public static void reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Node first = head;
        Node second = half(head);
        second = reverse(second);
        ListUtility.display(second);
        Node firstNext = null;
        Node secondNext = null;
        while (second != null) {
            firstNext = first.next;
            secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }


    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node half(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node result = slow.next;
        slow.next = null;
        return result;
    }
}
