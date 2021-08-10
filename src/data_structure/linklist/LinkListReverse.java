package data_structure.linklist;

public class LinkListReverse {


	public static void main(String[] args) {
		//Node list = LinkOperation.createSampleList();
		Node list = new Node(3,new Node(5));
		ListUtility.Print(list);
		System.out.println("After Reverse");
		//	Node revlist = reverseRecursive(list);
		Node revlist = reverseBetween(list,1,2);
		ListUtility.Print(revlist);
	}



	public static Node reverse(Node head){
          Node prev =  null;
          while(head != null){
			  Node next = head.next;
			  head.next = prev;
			  prev = head;
			  head = next;
		  }
		return prev;
	}


	/*
	https://leetcode.com/problems/reverse-linked-list-ii/
	 */
	public static Node reverseBetween(Node head,int m, int n){
		if(head == null || head.next == null || m == n){
			return head;
		}
		Node prev =  null;
		int count = 1;
		Node current = head;
		Node first = null;
		while (count < m && m != 1) {
			first = current;
			current = current.next;
			count++;
		};
		Node second = current;
		System.out.println("Current:"+current);
		Node next = null;
		while(count <= n){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		Node result = head;
		if(first != null){
			first.next = prev;
		}else {
			result  = prev;
		}
		if(second != null){
			second.next = next;
		}
		return result;
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
    
	
	
	


}
