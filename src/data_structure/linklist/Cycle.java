package data_structure.linklist;

public class Cycle {

    public static void main(String[] args) {

    }


    public boolean hasCycle(Node head) {
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while ( fast != null && fast.next != null){
            if(slow == fast){
                return  true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return  false;
    }
}
