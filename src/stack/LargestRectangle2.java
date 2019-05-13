package stack;

import java.util.Scanner;
import java.util.Stack;


//geekfor geek solution

public class LargestRectangle2 {
	
	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] h = new int[n];
//        for(int h_i = 0; h_i < n; h_i++){
//            h[h_i] = in.nextInt();
//        }
		//int [] h = {6,1,5,4,5,2,6};
		int [] h = {1,2,3,4,5};
        long result = largestRectangleAreaStack(h);
        System.out.println("Final Result: "+result);
      //  in.close();
    }

	private static long largestRectangleAreaStack(int[] h) {
		 Stack<Integer> s = new Stack<>();
		  long maxArea = 0; // Initialize max area
	      int i = 0;
	      while (i < h.length) {
	    	  if( s.isEmpty() || h[s.peek()] <= h[i]) {
	    		//  System.out.println("pushing in stack index:"+i + "Value:"+h[i]);
	    		  s.push(i++);
	    	  } else {
	    		  maxArea = Math.max(popStackAndCalculateArea(h, s, i), maxArea);
	    	  }
	      }
	      while(!s.empty()){
	    		maxArea = Math.max(popStackAndCalculateArea(h, s, i), maxArea);
	    		
	    	}
			
		return maxArea;
	}
	
	
	private static long popStackAndCalculateArea(int[] h, Stack<Integer> s, int i) {
		int top = s.peek();
		int height = h[s.pop()];
		int w = s.isEmpty() ? i : i - s.peek() - 1;
		//System.out.println("Removing "+height +  " for index:"+i +" area:"+height * w);
		return height * w;
	}
	
	

}
