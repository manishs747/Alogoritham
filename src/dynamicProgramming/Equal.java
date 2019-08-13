package dynamicProgramming;

import java.util.Arrays;

import Array.Utility;

/*
 * https://www.hackerrank.com/challenges/equal/problem
 * 
 * 
 * 
 * 1,1,5   -> 2
 * 2 2 3 7 -> 2
 * 10 7 12 -> 3
 * 
 * 
 * 
 */


public class Equal {

	public static void main(String[] args) {
		int [] arr1 = {1,1,5};
		int [] arr2 = { 2, 2 ,3 ,7};
		int [] arr3 = {10, 7, 12};
		//System.out.println(equal(arr3));
		System.out.println(1/2);
		
		

	}
	
	
	static int equal(int[] arr) {
	    int min = Arrays.stream(arr).min().getAsInt();
	    int ans = Integer.MAX_VALUE;
	    for (int i = 0; i < 5; ++i) {
	        int ops = 0;
	        for (int j = 0; j < arr.length; ++j) {
	            int t = arr[j] - (min - i);
	            ops  += t/5 + t%5/2 + t%5%2;
	        }
	        ans = Math.min(ans, ops);
	   }
	   return ans;
	}
	
	
	static int equalo(int[] arr) {
		int [] result = getMinMaxDiff(arr);
		int diff = result[0];
		int count = 0;
		while(diff != 0 && count < 10) {
			result = getMinMaxDiff(arr);
			diff = result[0];
			if (diff == 0) {
				return count;
			}
			int max = result[1];
			int  numToBeAdded =  numberTobeAdded(diff);
			for (int i=0;i < arr.length ;i++) {
				if(arr[i] != max) {
					arr[i] += numToBeAdded;
				}
			}
			count++;
		}
		return count;
	}


	private static int numberTobeAdded(int diff) {
		int numToBeAdded = 0;
		if (diff >= 5) {
			numToBeAdded = 5;
		}else if (diff >1 && diff <5 ) {
			numToBeAdded = 2;
		}else {
			numToBeAdded = 1;
		}
		return numToBeAdded;
	}

	// Method for getting the maximum value
	private static int[] getMinMaxDiff(int[] arr){ 
		int max = arr[0]; 
		int min  = arr[0];
		for(int i=1;i < arr.length;i++){ 
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		} 
		int [] result = {max-min,max};
		return result; 
	}
	 
	 
	
	
	
	

}
