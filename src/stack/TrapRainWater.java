package stack;

import java.util.Scanner;
import java.util.Stack;

import Array.Utility;

/*
 * 
 https://www.geeksforgeeks.org/trapping-rain-water/
 
 https://leetcode.com/articles/trapping-rain-water/
 
 Input: arr[]   = {2, 0, 2}
Output: 2
Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6


3
3
2 0 2 
6
3 0 0 2 0 4
12
0 1 0 2 1 0 1 3 2 1 2 1


1
12
0 1 0 2 1 0 1 3 2 1 2 1






 


2
10
6
 * 
 */


/*
 * 
 * DIFF - HEIGHT
 */

public class TrapRainWater {

	public static void main(String[] args) {
      
		
		/*Scanner in = new Scanner(System.in);
        int numberOfInput = in.nextInt();
        for (int i = 0; i < numberOfInput; i++) {
			int[] arr = getInputList(in);
			Utility.print(arr);
			System.out.println(getRainHarvested(arr));
		}*/
		//int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int [] height = {6,6,6,6,6,6};
		System.out.println(trap(height));
        
	}
	
	
	
	/*
	 * https://leetcode.com/problems/trapping-rain-water/
	 * 
	 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
	 * 
	 * 	
	 */
	
	
	public static int trap(int[] height) {
		if(height.length == 0) {
			return 0;
		}
		Stack<Integer>  stack = getMaxStacks(height);
		System.out.println(stack);
		int max = 0;
		int water = 0;
		for (int h : height) {
			max = Math.max(h, max);
			water += Math.min(max,stack.peek()) - h;
			if(stack.peek() == h) {
				stack.pop();
			}
		}
		return water;
	}

	public static Stack<Integer> getMaxStacks(int[] height){
		Stack<Integer>  stack = new Stack<>();
		stack.push(height[height.length -1]);
		for (int i = height.length -2 ; i  >= 0; i--) {
			int c = height[i];
			if(c >= stack.peek()) {
				stack.push(c);
			}
		}
		return stack;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static int getRainHarvested(int[] arr) {

		int water = 0;
		if (arr.length < 3) {
			System.out.println("Lenght is not sufficient to returning zero");
			return 0;
		}
		Stack<Integer> maxStack = getMaxStack(arr);
		int leftHeight = arr[0];

		for (int i = 1; i < arr.length - 1; i++) {
			int currentElelement = arr[i];
			int maxDiff = Math.min(leftHeight,maxStack.peek());
			int currentWaterLevel = maxDiff - currentElelement;
			System.out.println("Current Eleemnt is "+currentElelement + " and currentWaterLevel "+currentWaterLevel);
			if (currentWaterLevel > 0) {
				water = water + currentWaterLevel;
			}
			if (currentElelement == maxStack.peek()) {
				maxStack.pop();
			}
			if(leftHeight < currentElelement){
				leftHeight = currentElelement;
			}
		}
		return water;
	}


	private static Stack<Integer> getMaxStack(int[] arr) {
		Stack<Integer> maxStack = new Stack<Integer>();
		maxStack.push(arr.length-1);
		for (int i = arr.length -2; i > 0; i--) {
			int num = arr[i];
			if(num >= maxStack.peek()){
				maxStack.push(num);
			}
		}
		return maxStack;
	}


	private static int[] getInputList(Scanner in) {
		int size = in.nextInt();
		int[] arr = new int[size];
		for (int j = 0; j < size; j++) {
			arr[j] = in.nextInt();
		}

	return arr;
}

}
