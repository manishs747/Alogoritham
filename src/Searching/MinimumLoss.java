package Searching;
//https://www.hackerrank.com/challenges/minimum-loss/problem

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinimumLoss {
	
	
	public static void main(String[] args) {
		long [] price = { 20 ,7 };
		System.out.println(minimumLoss(price));
		
	}
	
	
	  static int minimumLoss(long[] price) {
		  Map<Long,Integer>  map =  getHashLoacation(price);
		  System.out.println("HASH:"+map);
		  Arrays.sort(price);
		  Array.Utility.print(price);
		  long minLoss = Long.MAX_VALUE;
		  for (int i = 1; i < price.length; i++) {
			  int j = i-1;
			  while(j >= 0) {
				  if(map.get(price[j]) > map.get(price[i])) {
					break;
				  }
				  j--;
			  }
			  System.out.println("I:"+i+" J:"+j);
			  if(j >= 0) {
				  minLoss = Math.min(minLoss, price[i] - price[j]);
				  System.out.println("MIN:"+minLoss);
			  }
		   }
          return (int) minLoss;
	    }
	  
	  private static Map<Long,Integer> getHashLoacation(long[] price){
		  Map<Long,Integer>  map = new HashMap<>();
		  for (int i = 0; i < price.length; i++) {
			map.put(price[i], i) ;
		}
		  return map;
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*************************************NOT WORKING**************************************/
    static int minimumLossN(long[] price) {
    	Stack<Long> stack = getMaxStackReverse(price);
    	//System.out.println(stack);
    	long minLoss = Integer.MAX_VALUE;
    	for (Long p : price) {
    		while(!stack.isEmpty() && stack.peek() >= p) {
    			stack.pop();
    		}
    		if(stack.isEmpty()) {
    			break;
    		}
    		minLoss = Math.min(minLoss, p - stack.peek());
		}
		return (int) minLoss;
    }
    
    public static Stack<Long>  getMaxStackReverse(long[] price) {
    	Stack<Long> stack = new Stack<>();
    	int len = price.length;
    	if (len == 0) {
    		return stack;
    	}
    	stack.push(price[len - 1]);
    	for (int i = len-2 ; i >= 0; i--) {
    		long  current = price[i];
    		if(current > stack.peek()) {
    			stack.push(current);
    		}
    	}
    	return stack;
    }


}
