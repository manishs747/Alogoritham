package linklist;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 *  A linked list is given such that each node contains an additional random pointer which could point
 * to any node in the list or null. Return a deep copy of the list.
 *
 * Time complexity is O(n)
 * Space complexity is O(1)
 * 
 * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 * 
 * 
 */
public class CopyLinkListWIthArbitPointer {
	
	static class RandomListNode {
        int data;
        RandomListNode next, random;
        RandomListNode(int x) { this.data = x; }
    }
	
	/*
	 *  Time complexity is O(n)
      * Space complexity is O(1)
      * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	 */
	private RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}

		// inserting in between curent node
		RandomListNode orgCurrent = head;
		while (orgCurrent != null) {
			RandomListNode cloneCurr = new RandomListNode(orgCurrent.data);
			cloneCurr.next = orgCurrent.next;
			orgCurrent.next = cloneCurr;
			orgCurrent = orgCurrent.next.next;
		}

		// fixing random pointer
		orgCurrent = head;
		while (orgCurrent != null) {
			orgCurrent.next.random = orgCurrent.random.next;
			orgCurrent = orgCurrent.next.next;
		}

		// fixing next
		orgCurrent = head;
		RandomListNode cloneHead = head.next;
		RandomListNode cloneCurrent;
		while (orgCurrent.next.next != null) {
			cloneCurrent = orgCurrent.next;
			orgCurrent.next = orgCurrent.next.next;
			cloneCurrent.next = cloneCurrent.next.next;
			orgCurrent = orgCurrent.next;
		}
		
		orgCurrent.next = null;

		return cloneHead;

	}
	/*
	 * 
	 * Time complexity : O(n)
Auxiliary space : O(n)
	 * 
	 * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
	 * 
	 */
	private RandomListNode copyRandomListHash(RandomListNode head) {
		 if(head == null){
			return head;
		   }
		 Map<RandomListNode,RandomListNode>  nodeMap = new HashMap<>();
		 
		 //filling hash
		 RandomListNode orgCurrent = head;
		 while(orgCurrent != null){
			 RandomListNode copy = new RandomListNode(orgCurrent.data);
			 nodeMap.put(orgCurrent,copy);
			 orgCurrent = orgCurrent.next;
		 }
		 
		 //processing copy node
		 orgCurrent = head;
		 while(orgCurrent != null){
			 RandomListNode cloneCurr = nodeMap.get(orgCurrent);
			 cloneCurr.next = nodeMap.get(orgCurrent.next);
			 cloneCurr.random = nodeMap.get(orgCurrent.random);
			 orgCurrent = orgCurrent.next;
		 }
			return nodeMap.get(head);
		}
	
	
	

	public static void main(String[] args) {
	     CopyLinkListWIthArbitPointer cll = new CopyLinkListWIthArbitPointer();

	        RandomListNode randomListHead = new RandomListNode(-1);
	        RandomListNode randomListNode1 = new RandomListNode(4);
	        RandomListNode randomListNode2 = new RandomListNode(8);
	        RandomListNode randomListNode3 = new RandomListNode(-3);
	        RandomListNode randomListNode4 = new RandomListNode(7);
	        randomListHead.next = randomListNode1;
	        randomListNode1.next = randomListNode2;
	        randomListNode2.next = randomListNode3;
	        randomListNode3.next = randomListNode4;

	        randomListHead.random = randomListNode1;
	        randomListNode2.random = randomListNode3;
	        randomListNode1.random = randomListHead;
	        
	        cll.copyRandomList(randomListHead);

	}

	

}
