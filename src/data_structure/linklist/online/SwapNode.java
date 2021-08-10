package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

public class SwapNode {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(swapNodes(node,5));
    }


    public static Node swapNodes(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLen(head);
        if (len % 2 != 0 && (len / 2) + 1 == k) {
            return head;
        }
        Node first = null;
        Node last = null;
        int count = 1;
        Node current = head;
        while (count <= k || count <= len - k + 1) {
            if (count == k) {
                first = current;
            }
            if (count == len + 1 - k) {
                last = current;
            }
            count++;
            current = current.next;
        }
        int tmp = first.data;
        first.data = last.data;
        last.data = tmp;
        return head;
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
