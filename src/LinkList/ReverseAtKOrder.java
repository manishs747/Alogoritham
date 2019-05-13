package linklist;

public class ReverseAtKOrder {
	
	//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
	
	public static Node recursiveHead;
	
	public static void main(String[] args) {
		
		Node head = Operation.creyateLinkList();
		
		ListUtility.display(head);
		head = ReverseKGroup(head,3);
		ListUtility.display(head);
	}
	
	/***************************************************************REVERSE K GROUP*************************************************************************************************************/
	
	/*
	 *https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
	 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
	   Output:  3->2->1->6->5->4->8->7->NULL
	 * 
	 */
	
	public static Node ReverseKGroup(Node head,int k){
		if(head == null) return null;
		Node prev = null,next = null, current = head;
		int count = 0;
		while(count<k && current != null ){
			next  = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		head.next = ReverseKGroup(next,k);
		return prev;
	}
	/***************************************************************ReverseKGroup  Except END*************************************************************************************************************/
	
	//https://leetcode.com/problems/reverse-nodes-in-k-group/
	static Node reversekExceptLastIncomplete(Node head, int k) {
		if(head == null) return null;
		Node prev = null,next = null, current = head, temp = head;
		int count = 0 ,len = 0;
		while(temp != null && len != k) {
			temp = temp.next;
			len++;
		}
		if (len != k) {
			System.out.println("K:"+k+" len:"+len);
			return head;
		}
		while(current != null && count  != k){
			next = current.next;
			current.next = prev;
			prev = current;
			current =  next;
			count++;
		}
		head.next = reversekExceptLastIncomplete(next, k);
		return prev;
	}
	/***************************************************************ReverseKGroup  ALTERNTE*************************************************************************************************************/
	
	/*
	   https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
	 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
    Output:   3->2->1->4->5->6->9->8->7->NULL. 
	 */
	static Node reversekGroupAlterNate(Node head, int k , boolean rotate) {
		if(head == null ||  !rotate) return head;
		Node prev = null,next = null, current = head;
		int count = 0;
		while(current != null && count  != k){
			next = current.next;
			current.next = prev;
			prev = current;
			current =  next;
			count++;
		}
		head.next = reversekGroupAlterNate(next, k , !rotate);
		return prev;
	}
	 
	/***************************************************************PAIRWISE SWAP*************************************************************************************************************/
	 
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
	 
	 /***************************************************************PAIRWISE SWAP*************************************************************************************************************/
	 
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
	
	
	
	
	
	
	
	 
	 

}
