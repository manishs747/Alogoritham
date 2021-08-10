package data_structure.linklist.online;

import data_structure.linklist.Node;

public class MergeInBetween {


    public static void main(String[] args) {

    }







    public Node mergeInBetween(Node list1, int a, int b, Node list2) {

        Node current = list2;
        while (current.next != null){
            current = current.next;
        }
        Node tail2 = current;
        Node bHead = null;
        current = list1;
        int count = 0;
        while (count <= b){
             if(count == a-1){
                 bHead = current;
             }
            current = current.next;
            count++;
        }
        Node bTail = current;
        bHead.next = list2;
        tail2.next = bTail;
        return  list1;
    }

}
