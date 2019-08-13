package linklist;

import java.math.BigInteger;

public class AddTwoNumber {
	
	
	

	public static void main(String[] args) {
		//[9]
		//[1,9,9,9,9,9,9,9,9,9]
		// TODO Auto-generated method stub
		AddTwoNumber adt = new AddTwoNumber();
		ListNode l1 =  new ListNode(0);
		//l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);
		
		
		ListNode l2 =  new ListNode(1);
		/*l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);*/
		
		System.out.println(adt.addTwoNumbers(l1, l2));

	}
	
	
	
	
	
	/*
	 * https://leetcode.com/problems/add-two-numbers/
	 * You are given two non-empty linked lists representing two non-negative integers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	 * `Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
	 * 
	 * 
	 * 
	 */
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	//doesnt work for all
	  public ListNode addTwoNumbersNFW(ListNode l1, ListNode l2) {
		long num =   getNumFromList(l1) + getNumFromList(l2);
		if (num == 0) {
			return new ListNode((int) num);
		}
		System.out.println("Num:"+num);
		ListNode head = null;
		ListNode current = head;
		while(num != 0) {
			System.out.println("Node:"+num % 10);
			ListNode node  = new ListNode((int) (num % 10));
			num = num/10;
			if(current == null) {
				current = node;
				head = current;
			}else {
				current.next =node;
				current = node;
			}
		}
		//System.out.println(head.val +","+head.next.val +","+head.next.next.val +",");
		return head;
	    }
	  
	  private long getNumFromList(ListNode l) {
		  long sum = 0;
		  int x = 0;
		  while(l != null) {
			  int val = l.val;
			  sum += val * Math.pow(10, x++);
			  l = l.next;
			 // System.out.println("Val"+val+"Sum:"+sum);
		  }
		//  System.out.println("Num:"+sum);
		  return sum;
	  }
	  
	  
	  public ListNode addTwoNumbersBI(ListNode l1, ListNode l2) {
		  BigInteger sum =   getNumFromListBI(l1).add(getNumFromListBI(l2));
			if (sum.intValue() == 0) {
				return new ListNode( 0);
			}
			String [] s = sum.toString().split("");
			ListNode head = new ListNode(Integer.parseInt(s[0]));
			ListNode current =  head;
		    for (int i = 1; i < s.length; i++) {
		    	current.next = new ListNode(Integer.parseInt(s[i]));
		    	current = current.next;
			}
			//System.out.println(head.val +","+head.next.val +","+head.next.next.val +",");
			return head;
		    }
		  
		  private BigInteger getNumFromListBI(ListNode l) {
			BigInteger sum = new BigInteger("0");
			  int x = 0;
			  while(l != null) {
				  int val = l.val;
				  sum= sum.add(new BigInteger( (val * Math.pow(10, x++)+"")));
				  l = l.next;
				 // System.out.println("Val"+val+"Sum:"+sum);
			  }
			//  System.out.println("Num:"+sum);
			  return sum;
		  }

}
