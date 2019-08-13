package Array;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/binary-search/
 * 
 * 
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = { 1,5,9,11,13,17,25};
		
	/*	int [] arr = {1, 4, 45, 6, 10, -8};
		Arrays.sort(arr);
		int x = -8;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			System.out.println("Value for:"+current+" is " + binarySearch(arr, 0, arr.length-1, current));
		}*/
		
		int [] nums = {1,3,5,6}; //5
		//int [] nums = {1,3,5,6};  //2
		//int [] nums = {1,3,5,6};  //7
		//int [] nums = {1,3,5,6};  //0
		
		//System.out.println(searchInsert(nums, 5));
		
		

	}
	
	/*
	 * Input: [1,3,5,6], 5
Output: 2


Input: [1,3,5,6], 2
Output: 1

Input: [1,3,5,6], 7
Output: 4

Input: [1,3,5,6], 0
Output: 0
	 */
	//  public static int searchInsert(int[] nums, int target) {
		   
		  
	        
	   //  }
	
	
	//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
	/*
	 * 
	 *  Find Minimum in Rotated Sorted Array
	 * Input: [3,4,5,1,2] 
Output: 1
	 */
	
	
	
	
	
	
	public static int binarySearch(int arr[], int l, int r, int x)
	    {
		if( l>r){
			return -1;
		}
		//System.out.println("l:"+l+" r:"+r);
		  int mid =l+ (r-l)/2;
		  int midElement = arr[mid];
		  if(midElement == x){
			  return mid;
		  }
		  
		  if(midElement > x){
			 return binarySearch(arr, l,mid -1 , x);
		  }else{
			 return binarySearch(arr, mid +1,r , x);
		  }
	
	    }

}
