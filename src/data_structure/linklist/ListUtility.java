package data_structure.linklist;

public class ListUtility {

	public static void main(String[] args) {

	}

	public static Node getSampleList(int [] arr){
		if(null == arr || arr.length == 0){
			return null;
		}
		Node head = new Node(arr[0]);
		Node current = head;
		for (int i = 1; i < arr.length ; i++) {
			current.next = new Node(arr[i]);
			current = current.next;
		}
		return head;
	}



    public static  int getListLength(Node headNode) {
        int length = 0;
        Node currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }


    public static void display(Node headNode) {
        for (Node currentNode = headNode; currentNode != null; currentNode = currentNode.next) {
            System.out.print(currentNode.data + " ");
        }
        System.out.println();

    }

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




}
