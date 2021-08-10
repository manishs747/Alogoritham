package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

public class OddEvenList {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 5, 6, 4};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);


    }

    /*
    https://leetcode.com/problems/odd-even-linked-list/
    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL


    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL
     */
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
           return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while ( odd != null && odd.next != null && even != null){
            odd.next = odd.next.next;
            if(odd.next == null){
                break;
            }
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
