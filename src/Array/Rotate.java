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
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	        	arr[i]=in.nextInt();
	        }
	        arrayLeftRotation(arr, k);
	        print(arr);
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
