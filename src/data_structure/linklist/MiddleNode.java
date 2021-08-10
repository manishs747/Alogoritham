package data_structure.linklist;

public class MiddleNode {


    public static void main(String[] args) {
        int[] arr = {1,2};
        Node node = ListUtility.getSampleList(arr);
        ListUtility.display(node);
        System.out.println(middleNode(node));
    }



    public static Node middleNode(Node head) {
        Node fp = head;
        while (fp != null && fp.next != null){
            head = head.next;
            fp = fp.next.next;
        }
        return head;
    }



    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
