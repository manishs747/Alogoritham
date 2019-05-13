package linklist;
/*
 * 
 * http://jonisalonen.com/2013/sorting-a-linked-list/
 * 
 * 
 * 
 * 
 */
public class SortLinkList {
	
	public static void main(String[] args) {	
		Node head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(6);
		head.next.next.next = new Node(5);
		
		ListUtility.display(head);
		Node bubbleResult = bubbleSort(head);
		ListUtility.display(bubbleResult);
	}
	
	
	
	static Node bubbleSort(Node head){
		int n  = ListUtility.getListLength(head);
		if(n < 2){
			return head;
		}
		swap(head);
		return head;
	}
	
	static void swap(Node prev){
		Node first = prev.next;
		Node second = first.next;
		prev.next = second;
		first.next = second.next;
		second.next = first;
	}

}
