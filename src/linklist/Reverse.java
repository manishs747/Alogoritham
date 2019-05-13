package linklist;

public class Reverse {
	
	public static Node recursiveHead;
	
	public static void main(String[] args) {
		Node list =  Operation.creyateLinkList();
		Utility.Print(list);
		System.out.println("After Reverse");
	//	Node revlist = reverseRecursive(list);
		Node revlist = reverseRecursive(list);
		Utility.Print(revlist);
	}
	
	/***************************************************************REVERSE PRINT*************************************************************************************************************/

	public static void ReversePrint(Node head) {
		if (head == null) {
			return;
		}
		System.out.println("Adding in stack:"+head.data);
		ReversePrint(head.next);
		System.out.println(head.data);
	}
	
	/***************************************************************REVERSE ITERATIVE*****************************************************************************************************************/
	public static Node reverseIterative(Node head){
		if(head == null){
			return head;
		}
		Node prev = null,next = null ,current = head ;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current =  next;
		}
		return prev;
	}
	
	/***************************************************************REVERSE RECURSIVE*************************************************************************************************************/

	
	public static Node reverseRecursive(Node head){
		if(head.next == null){
			return head;
		}
		Node newHead =  reverseRecursive(head.next);
	    head.next.next = head;
	    head.next = null;
		return newHead;
	}

	
	/***************************************************************REVERSE RECURSION STATIC HEAD*************************************************************************************************************/

	
	public static Node reverseRecursiveStaticHead(Node head) {
		if(head.next == null){
			recursiveHead = head;
			return head;
		}
		reverseRecursiveStaticHead(head.next);
		head.next.next = head;
		head.next = null;
		return recursiveHead;
	}
	
	/***************************************************************REVERSE RECURSION STATIC HEAD WITH PREV*************************************************************************************************************/


	// A simple and tail recursive function to reverse
	// a linked list.  prev is passed as NULL initially.
	static Node reverseRecursiveWithPrev(Node head, Node prev) {
		if (head.next == null) {
			recursiveHead = head;
			return null;
		}
		reverseRecursiveWithPrev(head.next, head);
		head.next = prev;
		prev = null;
		return recursiveHead;
	}
    

  	
  
}
