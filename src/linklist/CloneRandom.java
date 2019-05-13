package linklist;

public class CloneRandom {

	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {}

		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

	public static void main(String[] args) {
		CloneRandom cr = new CloneRandom();
		Node head = cr.getList2();
		head = cr.copyRandomList(head);
		while(head != null) {
			System.out.println("DATA:"+head.val+" :RANDOM: "+head.random.val);
			head = head.next;
		}
	}
	
	public Node getList2() {
		Node two = new Node(2, null, null);
		Node one = new Node(1, two, two);
		two.random = two;
		return one;
	}
	
	public Node getList() {
		Node five = new Node(5, null, null);
		Node four = new Node(4, five, null);
		Node three = new Node(3, four, five);
		Node two = new Node(2, three, null);
		Node one = new Node(1, two, three);
		two.random = one;
		four.random = three;
		five.random = two;
		return one;
	}


	public Node copyRandomList(Node head) {
         if (head == null) {
        	 return head;
         }
        Node cloneHead = new Node(head.val,null,head);
        Node cloneCurrent = cloneHead;
        head = head.next;
        while(head != null) { 
            cloneCurrent.next = new Node(head.val,null,head);
            cloneCurrent = cloneCurrent.next;
        	head = head.next;
        }
        cloneCurrent = cloneHead;
        while(cloneCurrent != null) { 
        	cloneCurrent.random = cloneCurrent.random.random;
        	cloneCurrent = cloneCurrent.next;
        }
		return cloneHead;
	}

}
