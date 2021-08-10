package data_structure.linklist;

public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,3,3,3};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(deleteDuplicate(node));
    }

    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     input : {1, 1, 1, 2, 2, 3, 4, 4, 5, 6};
     output: 3->5->6
     */

    public static Node deleteDuplicatesOptimised(Node head) {
        Node senital = new Node(0, head);
        Node prev = senital;
        while (head != null) {
            if (head.next != null && head.data == head.next.data) {
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return senital.next;
    }

    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     */
    public static Node deleteDuplicate(Node head) {
         Node cur = head;
         while (cur != null){
             if (cur.next != null && cur.data == cur.next.data) {
                 while (cur.next != null && cur.data == cur.next.data){
                     cur.next =  cur.next.next;
                 }
             }
             cur = cur.next;
         }
        return head;
    }







    public static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
