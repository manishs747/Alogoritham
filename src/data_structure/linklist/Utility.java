package data_structure.linklist;

public class Utility {
	
	public static void Print(Node head) {
		if (head == null) {
			return;
		}
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static int getListLength(Node headNode) {
		int length = 0;
		Node currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.next;
		}
		return length;
	}

}
