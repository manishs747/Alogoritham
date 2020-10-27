package data_structure.arrays;

import java.util.Scanner;




/*
 https://www.hackerrank.com/challenges/almost-sorted/problem
 http://gotitt.blogspot.in/2016/09/almost-sorted.html
 
 ascending order 
  If the array is already sorted, output yes on the first line. You do not need to output anything else
 
 
 
 INPUT:
6
1 5 4 3 2 6

yes
reverse 2 5
 
 
 
 * 
 * 
 * 
 */

public class AlmostSorted {
	
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        almostSorted(arr);
	        in.close();
	    }

	  static void almostSorted(int[] arr) {
		int startBp = isSorted(arr);
		if(startBp == -1){
			System.out.println("yes");
			return;
		}
		
	        
	        
	        
	    }
	  
	  
	  public static int isSorted(int[] arr) {
		  int breakPoint = -1;
		    for (int i = 0; i < arr.length - 2; i++) {
		        if (arr[i] > arr[i + 1]) {
		            return i+1; // It is proven that the array is not sorted.
		        }
		    }
		    return breakPoint; // If this part has been reached, the array must be sorted.
		}

	  

}
