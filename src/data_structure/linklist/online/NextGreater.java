package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

public class NextGreater {

     public static int count = 0;

    public static void main(String[] args) {
        int [] arr = {2,1,5};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
       // ArrayUtils.print(nextLargerNodes(node));
    }


    public static int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return new int[0];
        }
        head =  reverseList(head);
        int [] result = new int[count];
        int c = 0;
        int max = Integer.MIN_VALUE;
        while (head != null){
            if(head.val > max){
                max = head.val;
                result[c++] = 0;
            }else{
                result[c++] = max;
            }
            head = head.next;
        }
        rev(result);
      return result;
    }

    public static void rev (int [] array){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev =  null;
        while(head != null){
            count++;
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }




}
