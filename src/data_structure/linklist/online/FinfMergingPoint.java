package data_structure.linklist.online;

public class FinfMergingPoint {

    public static void main(String[] args) {
        SinglyLinkedListNode common = new SinglyLinkedListNode(2,new SinglyLinkedListNode(4));
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1,common);
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(3,common);
        System.out.println(findMergeNode(head1,head2));
    }


    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int l1 = getLength(head1);
        int l2 = getLength(head2);
        SinglyLinkedListNode big = head1;
        SinglyLinkedListNode small = head2;
        if(l1 < l2){
            big = head2;
            small = head1;
        }
        int count = Math.abs(l1-l2);
        while(count != 0){
            count--;
            big = big.next;
        }
        while(big != small){
            big = big.next;
            small = small.next;
        }
        return big.data;
    }

    public static int getLength(SinglyLinkedListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
       return length;
    }
}
