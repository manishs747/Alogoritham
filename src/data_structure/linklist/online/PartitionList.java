package data_structure.linklist.online;

import data_structure.linklist.ListUtility;
import data_structure.linklist.Node;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public static void main(String[] args) {
        int[] arr = {2,1};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        ListUtility.display(partition(node,2));
    }


    public static Node partition(Node head, int x) {
        if(null == head || head.next == null){
            return head;
        }
        Node senital = new Node(0);
        Node prev = senital;
        Node glHead =  null;
        Node gltail = null;
        while (head != null){
           if( head.data < x){
               prev.next = head;
               prev = prev.next;
           }else{
               if(glHead == null){
                   glHead  = head;
                   gltail = head;
               }else{
                   gltail.next = head;
                   gltail = gltail.next;
               }
           }
           head = head.next;
           prev.next = glHead;
           if(gltail != null){
               gltail.next = null;
           }

        }
        return senital.next;
    }
}
