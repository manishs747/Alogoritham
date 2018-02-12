package LinkList;

public class ReverseAtKOrder {
	
	//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
	
	public static Node recursiveHead;
	
	public static void main(String[] args) {
		
		Node head = LinkOperation.creyateLinkList();
		
		ListUtility.display(head);
		head = ReverseKiterative(head,3);
		ListUtility.display(head);
		
		
	}
	
	 public static Node ReverseKiterative(Node head,int k)
	    {
		 
		  if(head == null){
	    	   return null;
	       }
		  
		   Node current = head;
	       Node next = null;
	       Node prev = null;
	       int count = 0;
	     
	       
	       while(count<k && current != null ){
	    	   next  = current.next;
	    	   current.next = prev;
	    	   prev = current;
	    	   current = next;
	    	   count++;
	       }
	       
	       /* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
	          And make rest of the list as next of first node */
        	  head.next = ReverseKiterative(next,k);
         // System.out.println("Prev is:"+prev.data);
		 return prev;
		 
	    }
	 
	 
	 public static Node pairWisereverse(Node head){
		    Node temp = head;
	        /* Traverse only till there are atleast 2 nodes left */
	        while (temp != null && temp.next != null) {
	            /* Swap the data */
	            int k = temp.data;
	            temp.data = temp.next.data;
	            temp.next.data = k;
	            temp = temp.next.next;
	         }
			return head;
		}
	 
	public static Node pairWisereverseData(Node head){
	    Node temp = head;
        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {
 
            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
         }
		return head;
	}
	
	
	
	static Node reverseRecursive(Node current, Node prev) {
    	if (current.next == null) {
			recursiveHead = current;
			current.next = prev;
			return null;
		}
    	reverseRecursive(current.next, current);
    	current.next = prev;
    	return recursiveHead;
    }
	
	//better
	public static Node reverseRecursive(Node head) {
		if(head.next == null){
			recursiveHead = head;
			return head;
		}
		 reverseRecursive(head.next);
		 head.next.next = head;
		 head.next = null;
		return recursiveHead;
	}
	
	public static  Node reverseRecursiveHeadNonStatic(Node head) {
		if(head.next == null ){
			return  head;
		}
		Node first = head;
	    head = reverseRecursiveHeadNonStatic(first.next);
	    first.next.next = first;
	    first.next = null;
	    return  head;
	}
	
	
	
	 public static Node ReverseIterative(Node head)
	    {
		 Node prev = null;
		 Node current = head;
		 Node next = current;
		 if(head == null || head.next == null){
			 return head;
		 }
		 while(current != null){
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;		 
		 }
			return prev;
	    }
	 
	 

}
