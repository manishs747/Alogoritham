package data_structure.linklist;

public class rotateRight {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(rotateRight(node,5));
    }


    public static Node rotateRight(Node head, int k) {
        if (null == head) {
            return null;
        }
        int len = getLen(head);
        k = k % len;
        if(k == 0){
            return head;
        }
        int steps = len -k;
        Node cur = head;
        Node newHead = null;
        while (steps > 1){
            steps --;
            cur = cur.next;
        }
        newHead = cur.next;
        Node tmp = cur.next;
        cur.next = null;
        while(tmp != null && tmp.next != null){
            tmp =  tmp.next;
        }
        if(tmp != null){
            tmp.next = head;
        }
        return newHead;
    }


    public static int getLen(Node head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
