package Array;

import java.util.Arrays;

public class MergeSortedArray {
	
	
	
	public static void main(String[] args) {
		int [] nums1 = {1,2,3,0,0,0};
		int [] nums2 = {2,5,6};
		//int [] nums1 = {0};
		//int [] nums2 = {1};
		merge(nums1, 3, nums2, 3);
		Array.Utility.print(nums1);
		
	}
	
	
	
	/*
	 * Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
	 */
	
	  public static void merge(int[] nums1, int m, int[] nums2, int n) {
		  int c = nums1.length-1;
		  m = m-1;
		  n = n -1;
		  while(n >=0  && m >= 0) {
			  System.out.println(m);
			  if( nums1[m] > nums2[n]) {
				  nums1[c--] = nums1[m--];
			  }else {
				  nums1[c--] = nums2[n --];
			  }
		  }
		  
		  while (n >= 0) {
	            nums1[c--] =  nums2[n--];
	        }
		  
	    }
	  

	  
	  
	  
	  public int majorityElement(int[] nums) {
		  int maj = nums.length/2;
		  Arrays.sort(nums);
		  for (int i = 0; i < nums.length-maj; i++) {
			if(nums[i] == nums[i+maj-1]) {
				return nums[i];
			}
		  }
	       return -1;
	    }

}
