package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class MinMax {
	
	public static class Pair{
		 public static int min;
		 public static int max;
		 public Pair(int i, int j) {
		  this.min = i;
		  this.max = j;
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1000, 11, 445, 1, 330, 3000,5};
		//Pair pair = getMinMax(arr);
		//Pair pair = findMinMaxRecursive(arr,0,arr.length-1);
		//System.out.println("Min is "+pair.min + " Max is "+ pair.max);
		int [] array = {3,6,9,1};
/*		 List<Integer> list =  new ArrayList<>();
		for(int e :array) {
			list.add(e);
		*/

		System.out.println(maximumGapSorted(array));
	}
	
	
	
	/*
	 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

       If there is no solution possible, return -1     
	 * 
	 * A : [3 5 4 2]
       Output : 2 
       for the pair (3, 4)
       
        Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 

	 */
	
	 public int maximumGap(int[] nums) {
		 int maxDiff = 0;  
		 if(nums.length < 2) {
			 return 0;
		 }
		 return maxDiff;
	 }
	 
	 /*****************************************************maximumGapSorted*****************************************************************************/    
		
	 /*
	  * https://leetcode.com/problems/maximum-gap/
	  * 
	  * Given an unsorted array, find the maximum difference between the successive elements in its sorted form
         Return 0 if the array contains less than 2 elements.
	  * 
	  * Input: [3,6,9,1]
        Output: 3
        Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
	  */
	 
	 public static int maximumGapSorted(int[] nums) {
		 int maxDiff = 0;
		 if(nums.length < 2) {
			 return maxDiff;
		 }
		 Arrays.sort(nums);

		 for(int i= 1 ;i < nums.length ; i++) {
			 maxDiff = Math.max(maxDiff, nums[i] - nums[i-1]);
		 }
		 return maxDiff;
	 }
	 
	 public long mul(long x, long y){
	        return x * y;
	    }
	    public int maximumGapBucket(int[] nums) {
	        int len = nums.length;
	        int n = len;
	        if(len < 2){
	            return 0;
	        }
	        int mini = nums[0];
	        int maxi = nums[0];
	        for(int i = 0; i < len; i++){
	            mini = Math.min(mini, nums[i]);
	            maxi = Math.max(maxi, nums[i]);
	        }
	        if(mini == maxi){
	            return 0;
	        }
	        boolean[] empty = new boolean[n + 1];
	        for(int i = 0; i < n + 1; i++){
	            empty[i] = true;
	        }
	        int[] pmax = new int[n + 1];
	        int[] pmin = new int[n + 1];
	        
	        for(int i = 0; i < n; i++){
	            int idx = (int)(mul(nums[i] - mini, n + 1) / (maxi - mini));
	            if(idx > n){
	                idx = n;
	            }
	        if(empty[idx]){
	            empty[idx] = false;
	            pmax[idx] = nums[i];
	            pmin[idx] = nums[i];
	        }else{
	            pmax[idx] = Math.max(pmax[idx], nums[i]);
	            pmin[idx] = Math.min(pmin[idx], nums[i]);
	        }
	        }
	        int res = 0;
	        int last = -1;
	        for(int i = 0; i < n + 1; i++){
	            if(!empty[i]){
	                if(last < 0){
	                    last = pmax[i];
	                }else{
	                    res = Math.max(res, pmin[i] - last);
	                    last = pmax[i];
	                }
	            }
	        }
	        return res;
	    }
	 
	public static int maximumGap( List<Integer> A) {
		int maxDiff = -1;
		int min = 0;
		for (int i = 1; i < A.size(); i++) {
			if(A.get(i) >= A.get(min)) {
				maxDiff = Math.max(maxDiff, i-min);
			}else {
				min = i;
			}
		}
		return maxDiff;
	}
	  
	
	
	
	public static Pair getMinMax(int arr[]){
		Pair pair = new Pair(arr[0],arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			if(current > pair.max){
				pair.max = current;
			}
			if(current < pair.min){
				pair.min = current;
			}
		}
		return pair;
	}
	
	public static Pair findMinMaxRecursive(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end)
			return new Pair(arr[start], arr[start]);
		int mid = (start + end) / 2;
		Pair lpair = findMinMaxRecursive(arr, start, mid);
		Pair rpair = findMinMaxRecursive(arr, mid + 1, end);
		if (lpair == null) {
			return rpair;
		} else if (rpair == null) {
			return lpair;
		}
		System.out.println("Start is:" + start + " MID POINT:" + mid
				+ " end is:" + end);
		System.out.println("LEFT MAX:" + lpair.max + "RIGHT MAX:" + rpair.max);
		return new Pair(Math.min(lpair.min, rpair.min), Math.max(lpair.max,
				rpair.max));
	}



	

}
