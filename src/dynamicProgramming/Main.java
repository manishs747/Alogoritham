package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
\

https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/


 * 
 * 
 * 
 */

public class Main {
	
	public static final int price [] = {1, 5, 8, 9, 10, 17, 17, 20};

	public static void main(String[] args) {
	
		int [] prc = {1 ,  5 ,  8,   9  ,10,  17 , 17 , 20 };
		System.out.println(cutRod(prc, 8,new int[8]));
		
	
	}
	
	//cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}

	/*
	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 1   5   8   9  10  17  17  20     22 (by cutting in two pieces of lengths 2 and 6)

	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 3   5   8   9  10  17  17  20       24 (by cutting in eight pieces of length 1)

	*/
	
	/* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
	//top-down, recursive manner
	static int cutRod(int[] prc,int n , int [] arr){
		System.out.println("N:"+n);
		if(n < 1) {
			return 0;
		}
		if(arr[n-1] == 0) {
			for (int i = 0; i < n; i++) {
				arr[n-1] = Math.max(arr[n-1],prc[i]+ cutRod(prc,n-i-1,arr));
			}
		}
		return arr[n-1] ;
	}


}