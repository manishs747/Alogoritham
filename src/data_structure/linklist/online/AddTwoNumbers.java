package data_structure.linklist.online;


import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] arr = {7,3};
        Node l1 = ListUtility.getSampleList(arr);

        int[] arr2 = {0};
        Node l2 = ListUtility.getSampleList(arr2);
        ListUtility.display(addTwoNumbers2(l2,l1));


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>() ,stack2 = new Stack<>();
        addListToStack(l1,stack1);
        addListToStack(l2,stack2);
        ListNode current = null;
        int carry = 0;
        while (!stack1.empty() || !stack1.isEmpty() || carry != 0){
            int sum = carry + (stack1.isEmpty()? 0:stack1.pop()) + (stack2.isEmpty()? 0:stack2.pop());
            ListNode newCurrent = new ListNode(sum%10);
            carry = sum/10;
            newCurrent.next = current;
            current = newCurrent;
        }
        return current;
    }

    public static void addListToStack(ListNode l,Stack<Integer> stack){
        while (l !=null){
            stack.add(l.val);
            l = l.next;
        }
    }


    public static Node addTwoNumbers2(Node l1, Node l2) {
        Stack<Integer> stack1 = new Stack<>() ,stack2 = new Stack<>();
        addListToStack2(l1,stack1);
        addListToStack2(l2,stack2);
        Node current = null;
        int carry = 0;
        while (!stack1.empty() || !stack2.isEmpty() || carry != 0){
             int sum = carry + (stack1.isEmpty()? 0:stack1.pop()) + (stack2.isEmpty()? 0:stack2.pop());
            Node newCurrent = new Node(sum%10);
             carry = sum/10;
             newCurrent.next = current;
             current = newCurrent;
        }
        return current;
    }

    public static void addListToStack2(Node l,Stack<Integer> stack){
           while (l !=null){
               stack.add(l.data);
               l = l.next;
           }
    }

    /**
     * 7 -> 2 -> 4 -> 3 +  5 -> 6 -> 4
     *
     * @return
     * @7 -> 8 -> 0 -> 7
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
