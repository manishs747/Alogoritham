package LinkList;

public class LinkListReverse {
	
	public static void ReversePrint(Node head) {
		if (head == null) {
			return;
		}
		System.out.println("Adding in stack:"+head.data);
		ReversePrint(head.next);
		System.out.println(head.data);
	}
	
	
	public static Node reverseIterative(Node head){
		if(head == null){
			return head;
		}
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current =  next;
		}
		return prev;
	}
	
	public static Node recursiveHead;
	
	public static Node reverseRecursive(Node head) {
		if (head.next == null) {
			recursiveHead = head;
			return null;
		}
		Node first = head;
		reverseRecursive(first.next);
		first.next.next = first;
		first.next = null;
		return recursiveHead;
	}
	
	// A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    static Node reverseRecursive(Node current, Node prev) {
    	if (current.next == null) {
			recursiveHead = current;
			return null;
		}
    	System.out.println("Data on stack :"+current.data);
    	reverseRecursive(current.next, current);
    	current.next = prev;
    	prev = null;
    	return recursiveHead;
    }
    
	
	
	
	
	public static void main(String[] args) {
		Node list =  LinkOperation.creyateLinkList();
		Utility.Print(list);
		System.out.println("After Reverse");
	//	Node revlist = reverseRecursive(list);
		Node revlist = reverseRecursive(list,null);
		Utility.Print(revlist);
	}

}
