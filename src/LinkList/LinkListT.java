package LinkList;

import java.util.concurrent.ExecutionException;

public class LinkListT
{
	
	public  static NodeT head=null;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		try {
			creyateLinkList();
			ListUtility.display(head);
			head = rearrangeEvenOdd(head);
			ListUtility.display(head);
			//head=reverseLinkLISTREC(head);
			
			//head=reverseLinkListIterative(head);
			//ListUtility.display(head);
			
			
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void creyateLinkList() throws ExecutionException {
		insertLinkListAtBegin( 1);
		insertLinkListAtBegin( 2);
		insertLinkListAtBegin( 3);
		insertLinkListAtBegin( 4);
		insertLinkListAtBegin( 5);
		insertLinkListAtBegin( 6);
		insertLinkListAtBegin( 7);
		insertLinkListAtBegin( 8);
	}
	
	
	public static <T>void insertLinkListAtBegin(T data) throws ExecutionException{
		
		NodeT<T> nodeToInsert = new NodeT<T>(data, null);
		
		if(head==null){
			head=nodeToInsert;
			return ;
		}else{
			nodeToInsert.setNode(head);
			head = nodeToInsert;
		}
	}	
	
	public static <T> NodeT<T> reverseLinkLISTREC(NodeT<T> head) throws ExecutionException{
		 if(head.next==null){
			 return head;
		 }
		   NodeT<T> newhead =reverseLinkLISTREC(head.next);//most triky
		   head.next.next = head;
		   head.next = null;
		  
		 return newhead;
	}
	
	public static <T> NodeT<T> reverseLinkListIterative(NodeT<T> head) throws ExecutionException{
		NodeT<T> prev = null;
		NodeT<T> cur = head;
		NodeT<T> next = head;
		
		while(cur!=null){
			next = next.next;
			cur.next = prev;
			prev = cur;
			
			//ListUtility.display(cur);
			cur = next;
		  //System.out.println(prev.data +" , "+cur.data+" , "+next.data);	
		
			System.out.println();
			
		}
		//ListUtility.display(cur);
		 
		 return prev;
	}
	
	
	public static <T> NodeT<T> rearrangeEvenOdd(NodeT<T> head){
		
		  // Corner case
	    if (head == null)
	        return head;
	    
	 // Initialize first nodes of even and odd lists
	    NodeT<T> odd = head;
	    NodeT<T> even = head.next;
	    
	    NodeT<T> evenList = even;
	    while(true){
	    	
	    	// If there are no more nodes, then connect
	        // first node of even list to the last node
	        // of odd list
	    	if((odd != null) || (even != null) || (even.next != null)){
	    		odd.next = evenList;
	    		break;
	    	}
	    	
	    	// Connecting odd nodes
	    	odd.next = even.next;
	    	odd = even.next;
	    	
	    	// If there are NO more even nodes after
	        // current odd.
	        if (odd.next == null)
	        {
	            even.next = null;
	            odd.next = evenList;
	            break;
	        }
	    	
	    	even.next = odd.next;
	    	even = odd.next;
	    }
		return head;
	}

	

}
