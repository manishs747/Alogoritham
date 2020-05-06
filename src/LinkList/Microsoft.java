package linklist;

public class Microsoft {
	
	class LinkedListNode {
        int val;
        LinkedListNode next;
    }
	
	public static void main(String[] args) {
		
	
		
		
		
	}
	
	static LinkedListNode sort(int k, LinkedListNode list) {
		return sortKiterative(list, k);


    }
	
	 public static LinkedListNode sortKiterative(LinkedListNode head,int k)
	    {
		 
		  if(head == null){
	    	   return null;
	       }
		  
		  LinkedListNode current = head;
		  LinkedListNode next = null;
		  LinkedListNode prev = null;
	       int count = 0;
	     
	       sorth(k, head);
	       while(count<k && current != null ){
	    	   next  = current.next;
	       }
	       
	       
     	  head.next = sortKiterative(next,k);
      // System.out.println("Prev is:"+prev.data);
		 return prev;
		 
	    }
	
	
	public static void sorth(int size,LinkedListNode head) {
        if (size > 1) {
            for (int i = 0; i < size; i++ ) {
            	LinkedListNode currentNode = head;
            	LinkedListNode next = head.next;
                for (int j = 0; j < size - 1; j++) {
                    if (currentNode.val > next.val) {
                    	LinkedListNode temp = currentNode;
                        currentNode = next;
                        next = temp;
                    } 
                    currentNode = next;
                    next = next.next;                   
                } 
            }
        }
    }
	
	
	
	
	LinkedListNode mergeSort(LinkedListNode h) 
    {
        // Base case : if head is null
        if (h == null || h.next == null)
        {
            return h;
        }
 
        // get the middle of the list
        LinkedListNode middle = getMiddle(h);
        LinkedListNode nextofmiddle = middle.next;
 
        // set the next of middle node to null
        middle.next = null;
 
        // Apply mergeSort on left list
        LinkedListNode left = mergeSort(h);
 
        // Apply mergeSort on right list
        LinkedListNode right = mergeSort(nextofmiddle);
 
        // Merge the left and right lists
        LinkedListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
	
	LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b) 
	    {
		LinkedListNode result = null;
	        /* Base cases */
	        if (a == null)
	            return b;
	        if (b == null)
	            return a;
	 
	        /* Pick either a or b, and recur */
	        if (a.val <= b.val) 
	        {
	            result = a;
	            result.next = sortedMerge(a.next, b);
	        } 
	        else
	        {
	            result = b;
	            result.next = sortedMerge(a, b.next);
	        }
	        return result;
	 
	    }
	
	LinkedListNode getMiddle(LinkedListNode h) 
	    {
	        //Base case
	        if (h == null)
	            return h;
	        LinkedListNode fastptr = h.next;
	        LinkedListNode slowptr = h;
	         
	        // Move fastptr by two and slow ptr by one
	        // Finally slowptr will point to middle node
	        while (fastptr != null)
	        {
	            fastptr = fastptr.next;
	            if(fastptr!=null)
	            {
	                slowptr = slowptr.next;
	                fastptr=fastptr.next;
	            }
	        }
	        return slowptr;
	    }
	
	
	
	static long calculateCombinations(int n, int k) {
		long result = 0;
        long upper = n;
        for (int i = 1; i < k; i++) {
        	int p = n-i;
        	// System.out.println("upper:"+upper+" n-1 "+p);
        	upper = upper *(n-i);
		}
        
       // System.out.println("upper:"+upper);
        long lower = k;
        for (int i = k-1; i > 0; i--) {
        	lower = lower * i;
		}
       // System.out.println("lower:"+lower);
        result = upper / lower;
        return result;

    }

}
