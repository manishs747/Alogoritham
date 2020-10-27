package data_structure.linklist.online;

public class Reverse {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head,next = cur;
        while(null != next){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return head;
    }
}
