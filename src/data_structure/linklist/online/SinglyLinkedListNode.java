package data_structure.linklist.online;

public class SinglyLinkedListNode {
    public int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data){
        this.data = data;
    }

    public SinglyLinkedListNode(int data,SinglyLinkedListNode next) {
        this(data);
        this.next = next;
    }
}
