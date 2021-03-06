package linklist;

public class Operation {
	
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		Node head = createLinkList(arr);
		Utility.Print(head);
		head = insertLinkListAtBeginNew(null, 7);
		Utility.Print(head);
	}
	
	public static Node createLinkList(int [] arr)  {
		Node head = null;
		for (int i = arr.length-1; i >= 0; i--) {
			head = new Node(arr[i],head);
		}
		return  head;
	}
	
	
	public static Node insertLinkListAtBeginNew(Node head, int data) {
		return new Node(data,head);
	}
	
	public static Node insertLinkListAtBegin(Node head, int data) {
		Node nodeToInsert = new Node(data);
		if (head == null) {
			return nodeToInsert;
		} else {
			nodeToInsert.next = head;
			return nodeToInsert;
		}
	}


	public static Node InsertAtEnd(Node head, int data) {
		Node tmp = head;
		Node newNode = new Node(data);
		if (tmp == null) {
			return newNode;
		}
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
		return head;
	}
	
	/*
5
3 0
5 1
4 2
2 3
10 1

310542
	 */
	Node InsertNth(Node head, int data, int position) {
		Node newNode = new Node(data);
		if ( position == 0) {
			newNode.next =  head;
			return newNode;
		}else{
			int count = 1;
			Node current = head;
			while (count  != position) {
				current = current.next;
				count++;
			}
			newNode.next = current.next;
			current.next = newNode;
			return head;
		}
	}
	
	
	Node Delete(Node head, int position) {
		if (head == null) {
			return null;
		}
		if (position == 0) {
			head = head.next;
			return head;
		}
		Node current = head;
		int count = 1;
		while (count < position) {
			current = current.next;
			count++;
		}
		current.next = current.next.next;
		return head;
	}



public static Node creyateLinkList()  {
	Node head = new Node(8);
	head = insertLinkListAtBegin(head, 7);
	head = insertLinkListAtBegin(head, 6);
	head = insertLinkListAtBegin(head, 5);
	head = insertLinkListAtBegin(head, 4);
	head = insertLinkListAtBegin(head, 3);
	head = insertLinkListAtBegin(head, 2);
	head = insertLinkListAtBegin(head, 1);
	return  head;
	}
}
