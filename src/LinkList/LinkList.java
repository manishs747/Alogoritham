package linklist;

public class LinkList {
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6};
		Node list =  Operation.createLinkList(arr);
		System.out.println(getNode(list, 3));
	}

	private Node head;



	//adds in end
	public void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next =  new Node(data);
	}



	public void prepond(int data){
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}

	public void delete(int data) {
		if (head == null)
			return;
		if (head.data == data) { //if single node  only in this case head will chnage
			head = head.next;
			return;
		}
		Node current = head.next;
		while (current.next != null) {
			if (current.next.data != data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		System.out.println("Data not present in list:" + data);
	}
	
	static int getNode(Node head, int positionFromTail) {
		if (head == null) {
			return -1;
		}
		Node current = head;
		Node forward = head;
		int count = 0;
		while(count != positionFromTail) {
			count++;
			forward = forward.next;
		}
		while(forward.next != null) {
			current = current.next;
			forward = forward.next;
		}
        return current.data;
    }

	public Node getLinkList(){
		return head;
	}




}
