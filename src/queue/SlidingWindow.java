package queue;

import java.util.Deque;
import java.util.LinkedList;

import Array.Utility;

/*
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * https://www.interviewbit.com/problems/sliding-window-maximum/
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
   Output: [3,3,5,5,6,7] 
 * 
 */
public class SlidingWindow {

	public static void main(String[] args) {
	int [] nums = {1,3,1,2,0,5};
	int [] num = {7,2,4};
	 Utility.print(maxSlidingWindowSol(nums, 3));

	}
	
	//https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums==null||nums.length==0)
	        return new int[0];
	 
	    int[] result = new int[nums.length-k+1];
	 
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	 
	        deque.addLast(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}
	    

	public static int[] maxSlidingWindowSol(int[] nums, int k) {
		if (nums.length == 0 || nums.length == 0) {
			return nums;
		}
		int [] result = new int[nums.length - k+1];
		Deque<Integer> dequeue = new LinkedList<Integer>();
		for (int i = 0; i < k; i++)  {
			while (!dequeue.isEmpty() && nums[i] > nums[dequeue.peekLast()]) {
				dequeue.pollLast();
			}
			dequeue.addLast(i);
		}
		result[0] = nums[dequeue.peek()];
		for (int j = k; j < nums.length; j++) {
			//remove old entries
			while(!dequeue.isEmpty() &&  j-dequeue.peek() >= k) {
				dequeue.poll();
			}
			while (!dequeue.isEmpty() && nums[j] >= nums[dequeue.peekLast()]) {
				dequeue.pollLast();
			}
			dequeue.addLast(j);
			result[j-k+1] = nums[dequeue.peek()];
		}
		return result;
	}
	
	
	public static int[] maxSlidingWindowNK(int[] nums, int k) {
		int [] result = new int[nums.length - k+1];
		for (int i = 0; i <= nums.length-k; i++) {
			result[i] =  nums[i];
			for (int j = i+1; j < i+k; j++) {
				result[i] = Math.max(result[i], nums[j]);
			}
		}
		return result;
	}
	
	

	  
	
	
	
	

}
