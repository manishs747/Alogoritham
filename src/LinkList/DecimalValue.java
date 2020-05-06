package linklist;

public class DecimalValue {


    public static void main(String[] args) {
        int arr [] = {1,0,1};
        Node head = LinkOperation.createLinkListCustom(arr);
        ListUtility.display(head);
        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node currentNode = head;  currentNode!=null;currentNode=currentNode.next ) {
           sb.append(currentNode.data);
        }
       return Integer.parseInt(sb.toString(),2);
    }
}
