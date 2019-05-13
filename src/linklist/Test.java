package linklist;

public class Test {
	static Node head ;

	public static void main(String[] args) {
	    int [] arr = {1,2,3,4,5,6};
		Node list =  Operation.createLinkList(arr);
		Utility.Print(list);
		System.out.println("After Reverse");
		list = reverseRecursiveWithoutRecursiveHead(list);
        Utility.Print(list);
	}
	
	
	public static Node reverseRecursiveWithoutRecursiveHead(Node head){
		if(head.next == null){
			Test.head = head;
			return head;
		}
		Node newHead =  reverseRecursiveWithoutRecursiveHead(head.next);
	    head.next.next = head;
	    head.next = null;
		return newHead;
	}
	



}
