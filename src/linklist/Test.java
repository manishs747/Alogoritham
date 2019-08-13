package linklist;

import java.util.HashMap;
import java.util.Map;

public class Test {
	static Node head ;

	public static void main(String[] args) {
	    int [] arr = {1,2,3,4,5,6,7,8};
		Node list =  Operation.createLinkList(arr);
		Utility.Print(list);
		System.out.println("After Reverse");
		list = ReverseKGroup(list,3);
      //  Utility.Print(list);
		HashMap<String,String> val = new HashMap<>();
        val.put(null, "b");
        System.out.println(val.get(null));
	}


	public static Node ReverseKGroup(Node head,int k){
		if(head == null) {
			return head;
		}
		Node prev = null;
		Node current = head;
		Node next = head;
		int count = 0;
	    while( current != null && count < k) {
	    	next = current.next;
	    	current.next  = prev;
	    	prev = current;
	    	current = next;
	    	count++;
	    }
	    head.next = ReverseKGroup(current, k);
		return prev;
	}
	
	
	
	
	
  }
