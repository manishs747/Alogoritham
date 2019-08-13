package Searching;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr  [] = {4,5,6,7,8,1,3};
		System.out.println(findMin(arr));

	}
	
	
	
	
	public static boolean binarySearchRecursive(int arr[], int x)
    {
		return binarySearchRecursive(arr, x,0, arr.length -1);
    }
	
	public static boolean binarySearchRecursive(int arr[], int x ,int left, int right){
		System.out.println("Left:"+left+"Right:"+right);
		if (left > right) {
			return false;
		}
		int mid = left + ((right - left)/2);
		if(arr[mid] == x) {
			return true;
		} else if ( x < arr[mid] ) {  //check in left as mid is large than given value
			return binarySearchRecursive(arr, x,left, mid-1);
		} else {
			return binarySearchRecursive(arr, x, mid+1,right);
		}
    }
	
	
	public static boolean binarySearchIterative(int arr[], int x)
	{   
		
		int left = 0 ,right = arr.length -1;
		while(left <= right) {  //equal is important
			int mid = (left + right) / 2;
			if(arr[mid] == x) {
				return true;
			}else if (  x < arr[mid]) { 
				right = mid-1;
			}else {
				left = left + 1;
			}
		}
		return false;
	}
	
	/*
	 * https://leetcode.com/problems/search-insert-position/
	 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	 * 
	 * Input: [1,3,5,6], 5
Output: 2
Input: [1,3,5,6], 2
Output: 1

Input: [1,3,5,6], 7
Output: 4

	 */
	
	public static int searchInsert(int[] nums, int target) {
		return searchInsert(nums, target, 0, nums.length-1);
		 
	}
	
	public static int searchInsert(int[] nums, int target,int left,int right) {
		if(left > right) {
			return left;
		}
		int mid = left + ((right-left)/2);
		if ( target == nums[mid]) {
			return mid;
		}else if (target < nums[mid]) {
			return searchInsert(nums, target,left,mid-1);
		} else {
			return searchInsert(nums, target,mid+1,right);
		}
	}
	
	
	
	
	//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
	/*
	 * 
	 *  Find Minimum in Rotated Sorted Array
	 * Input: [3,4,5,1,2] 
Output: 1
	 */
	 public static int findMin(int[] nums) {
	        return findMin(nums, 0, nums.length-1);
	 }
	 
	 public static int findMin(int[] nums,int left,int right) {
		// System.out.println("Left:"+left+"Right:"+right);
		 if(nums.length == 1) {
			return nums[0] ;
		 }
		 if(nums[left] < nums[right]) {
			 return nums[left];
		 }
		 int mid = left + ((right-left)/2);
		 if(mid == 0) {
			 return Math.min(nums[mid], nums[mid+1]);
		 }
		 if(mid == nums.length-1) {
			 return Math.min(nums[mid-1], nums[mid]);
		 }	 
		 if(nums[mid-1]  > nums[mid] && nums[mid] < nums[mid+1]) {
			 return nums[mid];
		 }else if ( nums[mid]  < nums[left]  &&  nums[mid] < nums[right]){ //go in left
			 return findMin(nums, left, mid-1);
		 }else  {
			 return findMin(nums, mid+1, right);
		 }
	 }

}
