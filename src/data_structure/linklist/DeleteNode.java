package data_structure.linklist;

public class DeleteNode {


    public static void main(String[] args) {
        int[] arr = {};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(removeElement(node,1));
    }

    /*
    https://leetcode.com/problems/remove-linked-list-elements/

    more memmory efficint
     */
    public static Node removeElements(Node head, int val) {
        Node senital = new Node(-1, head);
        Node prev = senital;
        while (head != null) {
            while (head != null  && head.data == val) {
                head = head.next;
            }
            prev.next = head;
            prev = head;
            if(head != null){
                head = head.next;
            }
        }
        return senital.next;
    }


    public static Node removeElement(Node head, int val) {
        Node senital = new Node(-1, head);
        Node prev = senital;
        while (head != null) {
            if(head.data != val){
                prev.next = head;
                prev = head;
            }else{
                prev.next = null;
            }
          head = head.next;
        }
        return senital.next;
    }
}
