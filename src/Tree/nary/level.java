package Tree.nary;

import java.util.LinkedList;
import java.util.Queue;


public class level {
	
	public static void main(String[] args) {
		
	}
	
	
	
	  public static int maxDepth(Node root) {
		  int count = 0;
		  if (root == null) {
			  return count;
		  }
		  Queue<Node> queue = new LinkedList<Node>();
	       queue.add(root);
	       queue.add(null);
	       while(!queue.isEmpty()) {
	    	   Node tmp = queue.poll();
	    	   if (queue.isEmpty()) {
	    		   return count;
	    	   }
	    	   if(tmp == null) {
	    		   queue.add(null);
	    		   count++;
	    	   }else {
	    		   for (Node node : tmp.children) {
	    			   queue.add(node);
				   }
	    	   }
	        }
		return count;
	  }

}
