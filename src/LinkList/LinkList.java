package linklist;

public class LinkList {
	
	private Node head;
	
	//adds in end
	public void append(int data){
		if(head == null){
		   head = new Node(data);
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next =  new Node(data);
	}
	
	
	
	public void prepond(int data){
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void delete(int data) {
		if (head == null)
			return;
		if (head.data == data) {
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
	
	public Node getLinkList(){
		return head;
	}
	
	
	public static void main(String[] args) {
		
	}

}
