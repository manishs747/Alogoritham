package data_structure.linklist;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        System.out.println(isPalindrome(node));
    }


    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null){
            return  true;
        }
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        while (current != null){
            stack.add(current.data);
            current = current.next;
        }
        while (head != null){
            if(head.data != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
