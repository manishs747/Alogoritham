package data_structure.linklist.online;

public class CompareLists {

   public class SinglyLinkedListNode {
         int data;
         SinglyLinkedListNode next;
    }



    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
       while(null != head1 && null != head2){
           if(head1.data != head2.data){
               return false;
           }
           head1 = head1.next;
           head2 = head2.next;
       }
       return null == head1 && null == head2 ?true:false;
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (null != node && null != node.next){
           if(node.data == node.next.data){
               node.next = node.next.next;
               continue;
           }
            node = node.next;
        }
       return head;
    }
}
