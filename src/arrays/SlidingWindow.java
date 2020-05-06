package arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



public class SlidingWindow {
	
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		//Output :
		//3 3 4 5 5 5 6
		//List<Integer> result = getIterativeMaxWindow(arr, k);
		//System.out.println(result);
		
		
		//printKMax(arr, k);
		printMaxDeQueue(arr, arr.length, k);
		
		
				
	}
	
	// A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    static void printMaxDeQueue(int arr[],int n, int k)
    {
    	// Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
         
        /* Process first k (or first window) elements of array */
       int i;
        for( i = 0; i < k; i++)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear
             
            // Add new element at rear of queue
            Qi.addLast(i);
        }
        System.out.println(Qi);
     // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
             
            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();
             
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
             
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
             
        }
         
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    	
    	
    	
    }
	
	   static void printKMax(int arr[], int k) 
	    {
	        int j, max;
	 
	        for (int i = 0; i <= arr.length - k; i++) {
	             
	            max = arr[i];
	 
	            for (j = 1; j < k; j++) 
	            {
	                max = Math.max(max, arr[i + j]);
	            }
	            System.out.print(max + " ");
	        }
	    }


     //nk complexity
	private static List<Integer> getIterativeMaxWindow(int[] arr, int k) {
		List<Integer> result = new ArrayList<Integer>();
		int max = getMax(arr, 0, k);
		
		result.add(max);
		
		
		for (int i = k; i < arr.length; i++) {
			int start = i-k+1;
			int end = start + k;
			result.add(getMax(arr, start, end));
		}
		return result;
	}
	
	
	
	public  static int getMax(int[] arr,int start ,int end){
		 int max = arr[start];
		for (int i = start+1; i < end; i++) {
			//System.out.println("Checkinh:"+arr[i] + "with max"+max);
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}
