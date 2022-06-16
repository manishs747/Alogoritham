package data_structure.linklist.online;


import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] arr = {7, 2, 4, 3};
        Node l1 = ListUtility.getSampleList(arr);

        int[] arr2 = {5, 6, 4,6};
        Node l2 = ListUtility.getSampleList(arr2);


    }

    /**
     * 7 -> 2 -> 4 -> 3 +  5 -> 6 -> 4
     *
     * @return
     * @7 -> 8 -> 0 -> 7
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode senital = new ListNode(-1);
        ListNode current = senital;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = l1 == null ? l2:l1;
        while (node != null){
            int sum = node.val  + carry;
            carry = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
            node = node.next;
        }
        if (carry != 0){
            current.next = new ListNode(carry);
        }
        return reverse(senital.next);
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}