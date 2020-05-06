package stack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 *  https://www.hackerrank.com/challenges/equal-stacks?h_r=next-challenge&h_v=zen
 You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.
 
 *  input
 *  5 3 4
    3 2 1 1 1
    4 3 2
    1 1 4 1
    
    output
    5
 * 
 * 
 */



public class EqualStacks {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int n1 = in.nextInt();
	        int n2 = in.nextInt();
	        int n3 = in.nextInt();
	        
	        Map<String,Integer> sumMap = new HashMap<>();
	        String hh1 = "h1";
	        String hh2 = "h2";
	        String hh3 = "h3";
	        
	        Stack<Integer> h1 = getStack(in, n1,hh1,sumMap);
	        Stack<Integer> h2 = getStack(in, n2,hh2,sumMap);
	        Stack<Integer> h3 = getStack(in, n3,hh3,sumMap);
	        
	        System.out.println(h1);
	        System.out.println(h2);
	        System.out.println(h3);
	        System.out.println(sumMap);
	        
	        
	        
	        while(!isEqual(sumMap, hh1, hh2, hh3)){
	        	
	        	String maxHeight = getMaxHeight(sumMap, hh1, hh2, hh3);
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        }
	        
	        
	    
	}

	private static String getMaxHeight(Map<String, Integer> sumMap, String hh1,
			String hh2, String hh3) {
		String maxHeight = hh1;
		if(sumMap.get(hh1) < sumMap.get(hh2)){
			maxHeight = hh2;
		}
		if(sumMap.get(maxHeight) < sumMap.get(hh3)){
			maxHeight = hh3;
		}
		return maxHeight;
	}

	private static boolean isEqual(Map<String, Integer> sumMap, String hh1,
			String hh2, String hh3) {
		return (sumMap.get(hh1)==sumMap.get(hh2)) && (sumMap.get(hh2)==sumMap.get(hh3));
	}

	private static Stack<Integer> getStack(Scanner in, int n ,String key, Map<String,Integer> sumMap) {
		Stack<Integer> h1 = new Stack<Integer>();
		int sum = 0;
		for(int h1_i=0; h1_i < n; h1_i++){
			int num = in.nextInt();
			h1.push(num);
			sum = sum + num;
		}
		sumMap.put(key, sum);
		return reverseCollection(h1);
	}
	
	public static Stack<Integer> reverseCollection(Stack<Integer> oldStack){
		Collections.reverse(oldStack);
		return oldStack;
	}

	
}
