package linklist;

public class MergerTwoSortedLinklist {
	
	
	public static void main(String[] args) {
		Node headA = new Node(1);
		headA.next = new Node(3);
		headA.next.next = new Node(5);
		headA.next.next.next = new Node(6);
		
		Node headB = new Node(2);
		headB.next = new Node(4);
		headB.next.next = new Node(7);
		
		ListUtility.display(headA);
		ListUtility.display(headB);
		Node merge = mergeLists(headA, headB);
		ListUtility.display(merge);
		
	}
	
	
	
	static Node mergeLists(Node headA, Node headB) {
		Node head = null ;
		Node current = null;
		if(headA == null){
			return headB;
		}
		if(headB == null){
			return headA;
		}

		while(headA != null && headB != null){
			Node tmp ;
			if(headA.data < headB.data ){
				tmp = headA;
				headA = headA.next;
			}else{
				tmp = headB;
				headB = headB.next;
			}
			if(head == null){
				head = current = tmp;
			}else{
				current.next = tmp;
				current = tmp;
			}
		}

		if(headA == null){
			current.next = headB;
		}else{
			current.next = headA;
		}

		return head;
	}

}
