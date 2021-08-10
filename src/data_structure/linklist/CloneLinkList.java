package data_structure.linklist;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkList {


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val,Node next ,Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        @Override
        public String toString() {
            String ran = random == null ? "NULL" : random.val +"";
            String n = next == null ? "NULL" : next.val+"";
            return "{" +
                    "val=" + val +
                    ", next=" + n +
                    ", random=" + ran +
                    '}';
        }
    }


    public static void main(String[] args) {
        Node one = new Node(1);

        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.random = null;
        one.next = two;

        two.random = one;
        two.next = three;

        three.random = four;
        three.next = four;

        four.random = three;
        four.next = five;

        five.random = one;
        five.next = null;

        //display(one);
        copyRandomList(one);









    }

    /*
    https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
    https://leetcode.com/problems/copy-list-with-random-pointer/

     */
    public static Node copyRandomListWithSpace(Node head) {
        Node current = head;
        Node dummy = new Node(-1);
        Node copyPrev = dummy;
        Map<Node,Node> map = new HashMap<>();
        while(current != null){
            map.put(current,current.next);
            Node copyNode = new Node(10*current.val)   ;
            copyNode.random = current;
            copyPrev.next = copyNode;
            Node currentNext = current.next;
            current.next = copyNode;
            current = currentNext;
            copyPrev = copyPrev.next;
        }
        Node copyCurrent = dummy.next;

        while (copyCurrent != null ){
            if( copyCurrent.random.random == null){
                copyCurrent.random = null;
            }else{
                copyCurrent.random = copyCurrent.random.random.next;
            }
            copyCurrent = copyCurrent.next;
        }

        current = head;
        while (current != null){
            current.next = map.get(current);
            current = current.next;
        }
        return dummy.next;
    }

    public static Node copyRandomList(Node head) {
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(10*current.val, current.next, null);
            current.next = copyNode;
            current = current.next.next;
        }
        Node copyHead = head.next;
        current = head;
        Node copy = copyHead;
        while (current != null && current.next != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        while (current != null && copy.next != null){
            current.next = current.next.next;
            copy.next = copy.next.next;
            current = current.next;
            copy = copy.next;
        }
        current.next = null;
        return copyHead;
    }


    public static void display(Node headNode) {
        for (Node currentNode = headNode; currentNode != null; currentNode = currentNode.next) {
            System.out.println(currentNode);
        }
        System.out.println();

    }
}
