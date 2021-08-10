package data_structure.linklist;

public class Intersection {

    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {11,12,13,14};
        int[] arr3 = {3,4,5,6};

        Node node1 = ListUtility.getSampleList(arr1);
        Node node2 = ListUtility.getSampleList(arr2);
        Node node3 = ListUtility.getSampleList(arr3);
        node1.next.next = node3;
        node2.next.next.next.next = node3;
        ListUtility.display(node1);
        ListUtility.display(node2);
        System.out.println(getIntersectionNode(node1,node2));
    }



    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
           return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int diff = Math.abs(lenA-lenB);
        Node large = headA;
        Node small = headB;
        if(lenA <  lenB){
            large =  headB;
            small = headA;
        }
        int count = 0;
        while (count < diff){
            large = large.next;
            count++;
        }
        while (large != null && small != null){
            if(large == small){
                return large;
            }
            large = large.next;
            small = small.next;
        }
        return null;
    }


    public static int getLen(Node head){
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }
        return count;
    }



}
