package Hackerrank;

import java.io.*;
import java.util.Scanner;

public class LendingCart {
	
	
	public static void main(String[] args) {
	//	Scanner in = new Scanner(System.in);
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			
			long X = Long.parseLong(in.next().trim());
            long A = Long.parseLong(in.next().trim());
            long B = Long.parseLong(in.next().trim());
			long out_ = number_creation(A, X, B);
            System.out.println(out_);
			
		}
	
		
		int[] p = {1,2,3,4,9,8};
	//	System.out.println(solve(p ));
		
		//System.out.println(solve(42,5));
		
		//System.out.println(number_creation(1, 4, 5));
	}
	
	
	static long number_creation(long A, long X, long B) {
		// Write your code here
		// X is actual numer a +- b double
		long result = 0;
		if (X == 0) {
			return result;
		}
		long current = 1;
		result = A;
		while (current != X) {

			if (2 * current <= X) {
				//System.out.println("COST:"+Math.min(A * current, B));
				result = result + Math.min(A * current, B);
				current = 2 * current;
			} else {
				long dobbleSubCost = current * B + A * (current * B - X);
				long addCost = (X - current) * A;
				result = result + Math.min(dobbleSubCost, addCost);
				current = X;
			}
		}
		return result;

	}
	 
	 
	
	 static String solve(int k, int n){
	        // Write your code here
	        //n is lenght of characters
	        StringBuffer buffer = new StringBuffer();
	        int numberOfZ = k/26;
	        int restChar = n - numberOfZ;
	        int numberOfA = restChar -1;
	        for (int i = 0; i < numberOfA; i++) {
	        	buffer.append('a');
			}
	        
	        int valueOfOtherChar = k%26 -numberOfA;
	       char  c = (char) ('a' +valueOfOtherChar-1);
	        buffer.append(c);
	        for (int i = 0; i < numberOfZ; i++) {
	        	buffer.append('z');
			}
	        
	       return  buffer.toString();
	     
	    }
	 
	 
	 static int solve(int[] p){
	        // Write your code here
		 //starting index
		 int maxProfit = Integer.MIN_VALUE;
		 for (int i = 0; i < p.length; i++) {
			 int max = p[i];
			 int current = p[i];
			 for (int j = i+1; j < p.length; j++) {
				if(p[j] % current == 0){
					current = p[j];
					max = max + current;
				}
				
			}
			 maxProfit = Math.max(maxProfit, max);
			
		 }
	    return maxProfit;
	    }
	 
	

}
