package stack;

import java.util.Scanner;
import java.util.Stack;

/*
 * 
 https://www.hackerrank.com/challenges/largest-rectangle/problem
 * 
 * 
5
1 3 2 4 5
9

5
1 2 2 2 1
9

7
6 2 5 4 5 1 6
12

6
2 1 5 6 2 3
return 10.

7
6 2 5 4 5 1 6
12

 */

public class LargestRectangle {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        long result = largestRectangleAreaStack(h);
        System.out.println("Final Result"+result);
        in.close();
    }

	//https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	// Create an empty stack. The stack holds INDEXES of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
	
	
	//its really good  Best Sollution
	static long largestRectangleN(int[] h) {
        Stack<Integer> s = new Stack<>();
         
        long maxArea = 0; // Initialize max area
    	int i = 0;
      
    	while(i < h.length){
    		if(s.isEmpty() || h[s.peek()] <= h[i]){
    			System.out.print("pushing in stack index:"+i + "Value:"+h[i]);
    			s.push(i++);
    			System.out.println(" stack is :"+s);
    		}else{
    			System.out.println("removing from stack: "+i);
    			maxArea = popStackAndCalculateMax(h, s, maxArea, i);
    		}
    	}
    	
    	while(!s.empty()){
    		System.out.println("STACK IS NOT EMPTY");
    		maxArea = popStackAndCalculateMax(h, s, maxArea, i);
    	}
		return maxArea;
    }
	
	public static long largestRectangleAreaStack(int [] arr){
		long max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(stack.empty()){
			//	System.out.println("Adding in Empty Stack:"+arr[i]);
				stack.push(i);
				continue;
			}
			int item = arr[i];
			if(item > arr[stack.peek()]){
				stack.push(i);
			}else{
				while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
					max = popStackAndCalculateMax(arr, stack, max, i);
				}
				stack.push(i);
			}
		}
		System.out.println(stack);
		if(!stack.empty()){
			int parentIndex = stack.peek();
			while(!stack.empty()){
				max = popStackAndCalculateMax(arr, stack, max, parentIndex);
			}
		}
		return max;
	}

	private static long popStackAndCalculateMax(int[] h, Stack<Integer> s,
			long maxArea, int i) {
		int height = h[s.pop()];
		int w = s.isEmpty() ? i : i - s.peek() - 1;
		System.out.println("Removing height:"+height+" Lenght:"+w +" i="+i);
		maxArea = Math.max(height * w, maxArea);
		return maxArea;
	}
	
	
	private static long  largestRectangleN2(int[] arr) {
		
		long maxAra = 0;
		for (int i = 0; i < arr.length; i++) {
			int height = arr[i];
			int lenght = getLenght( i, arr);
			System.out.println("AREA for I :"+ i+ " is "+lenght*height);
			maxAra = Math.max(maxAra, lenght*height);
		}
		return maxAra;
	}

	private static int getLenght(int i, int[] arr) {
		int left = 0;
		int right = 0;
		int h = arr[i];
         for (int j = i-1; j >= 0; j--) {
			int ch = arr[j];
			if(ch < h){
				break;
			}
			left++;
		}
		for (int j = i+1; j < arr.length; j++) {
			int ch = arr[j];
			if(ch < h){
				break;
			}
			right++;
			
		}
		int lenght = left + right + 1;
		//System.out.println("Lenght for index "+i+" is "+lenght+" left: "+left+" right: "+right);
		return lenght;
	}
	
	
	

    

}
