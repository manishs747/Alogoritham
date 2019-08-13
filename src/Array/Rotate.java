package Array;

import java.util.Scanner;


//sample input rotate left
/*
5 2
1 2 3 4 5
*/
/*
 * output
 * 3 4 5 1 2
 */



/*
 *  https://www.geeksforgeeks.org/array-rotation/
 *  
 *  
 * 
 * 
 */
public class Rotate {
	
	//O(1) space and in O(n)
	   public static void arrayLeftRotation(int[] arr, int k) {
		   if(k > arr.length) 
		        k=k%arr.length;
		   revreseArray(arr,0,k-1);
		   revreseArray(arr,k,arr.length-1);
		   revreseArray(arr,0,arr.length-1);
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums = {1,2,3,4,5,6,7};
			rotateRight(nums , 3);
	        print(nums);
	    }
   /*****************************************************Rotate HackerRank*****************************************************************************/ 
	    /*
	     * 5 4
          1 2 3 4 5  //input 
          
          5 1 2 3 4   //output
          
          
           1 2 3 4 5  //input   k = 3
          
           3 4 5 1 2   //output
          
          
	     */
	    
	    public static void leftRotate(int [] arr,int k) {
	    	
	    }
	    
	    /*****************************************************Rotate HackerRank*****************************************************************************/ 
	   // https://www.hackerrank.com/challenges/circular-array-rotation/problem
	    	
	    	
	    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
	    	rotateRight(a, k);
	    	int [] result = new int [queries.length];
	    	for (int i = 0; i < queries.length ;i++) {
	    		result[i] = a[queries[i]];
			}
           return result;
	    }
	    
	    
	    
	    
	/*****************************************************Rotate*****************************************************************************/    
	    /*
	     * 
	     * https://leetcode.com/problems/rotate-array/
	     * 
	     *  Input: [1,2,3,4,5,6,7] and k = 3
			Output: [5,6,7,1,2,3,4]
			Explanation:
			rotate 1 steps to the right: [7,1,2,3,4,5,6]
			rotate 2 steps to the right: [6,7,1,2,3,4,5]
			rotate 3 steps to the right: [5,6,7,1,2,3,4]
	     * 
	     */
	    public static void rotateRight(int[] nums, int k) {
	    	 if(k > nums.length) 
			        k=k%nums.length;
	    	 if ( k == 0) {
	    		 return ;
	    	 }
	    	  revreseArray(nums,0,nums.length-1);
	    	  revreseArray(nums,0,k-1);
			  revreseArray(nums,k,nums.length-1);
	    }
	    
	    static void revreseArray(int arr[], int start, int end)
	    {
	      while(start<end){
	    	  int tmp = arr[start];
	    	  arr[start] = arr[end];
	    	  arr[end]=tmp;
	    	  start = start+1;
	    	  end = end -1 ;
	    	  
	      }
	    } 	

	

		private static void print( int[] arr) {
			for(int i = 0; i < arr.length; i++)
	            System.out.print(arr[i] + " ");
	      
	        System.out.println();
		}

}
