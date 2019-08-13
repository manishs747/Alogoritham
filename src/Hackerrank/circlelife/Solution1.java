package Hackerrank.circlelife;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		//int [] ar = {2,3,10,2,4,8,1};
		arr.add(2);
		arr.add(3);
		arr.add(10);
		arr.add(2);
		arr.add(4);
		arr.add(8);
		arr.add(1);
		System.out.println(arr);
		System.out.println(maxDifference(arr));

	}
	
	
	  //submitted working
	  static int maxDifference1(List<Integer> arr) {
		    int minimum, diff = -1;
		    if(arr.size() == 0) {
		        return diff;
		    }
		    minimum = arr.get(0);
		    for (int i = 1; i < arr.size(); i++) {
		        diff = Math.max(diff, arr.get(i) - minimum);
		        minimum = Math.min(minimum, arr.get(i));
		    }
		 
		    return diff > 0 ? diff : -1;
		}
	
	
	public static int maxDifference(List<Integer> arr) {
		int result = -1;
		for (int i = 1; i < arr.size(); i++) {
			for (int j = i; j >= 0; j--) {
				if (arr.get(j) < arr.get(i)) {
					result = Math.max(result, arr.get(i) - arr.get(j));
				}
			}
		}
		return result;
	}
	
	
	//working 2 case missing
	  int maxDiff(List<Integer> arr)  
	    { 
		  int arr_size = arr.size();
	        int max_diff = arr.get(1) - arr.get(0);
	        if (max_diff < 0) {
	            max_diff = -1;
	        }
	        int min_element = arr.get(0);
	        int i;
	        for (i = 1; i < arr_size; i++) {
	            if (arr.get(i) - min_element > max_diff)
	                max_diff = arr.get(i) - min_element;
	            if (arr.get(i) < min_element)
	                min_element = arr.get(i);
	        }
	        return max_diff; 
	    }
	  
	  
	  static int maxDiff1(List<Integer> arr) 
	  { 
		  
		  int n = arr.size();
	      // Initialize Result 
	      int maxDiff = -1;  
	        
	      // Initialize max element from right side 
	      int maxRight = arr.get(n-1);  
	    
	      for (int i = n-2; i >= 0; i--) 
	      { 
	          if (arr.get(i) > maxRight) 
	              maxRight = arr.get(i); 
	          else
	          { 
	              int diff = maxRight - arr.get(i); 
	              if (diff > maxDiff) 
	              { 
	                  maxDiff = diff; 
	              } 
	          } 
	      } 
	      return maxDiff; 
	  } 
	  
	  
	  

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  int maxDiff(int arr[], int n)  
	    { 
	        // Create a diff array of size n-1. The array will hold 
	        //  the difference of adjacent elements 
	        int diff[] = new int[n - 1]; 
	        for (int i = 0; i < n - 1; i++) 
	            diff[i] = arr[i + 1] - arr[i]; 
	  
	        // Now find the maximum sum subarray in diff array 
	        int max_diff = diff[0]; 
	        for (int i = 1; i < n - 1; i++)  
	        { 
	            if (diff[i - 1] > 0)  
	                diff[i] += diff[i - 1]; 
	            if (max_diff < diff[i]) 
	                max_diff = diff[i]; 
	        } 
	        return max_diff; 
	    } 

}
