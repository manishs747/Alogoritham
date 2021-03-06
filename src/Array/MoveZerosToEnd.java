package Array;

import utils.ArrayUtils;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] myList = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		//ArrayUtils.print(myList);
		//pushZerosToEnd(myList);
		pushZerosToEndCountMethod(myList);
		ArrayUtils.print(myList);
	}
	
	
	/*https://leetcode.com/problems/sort-array-by-parity/
	 * 	[3,1,2,4]
       Output: [2,4,3,1]    move even to begining and odd at end
	 * 
	 */
	  public int[] sortArrayByParity(int[] A) {
		  int result [] = new int [A.length];
		  int start = 0;
		  int end = A.length -1;
	      for (int val :A) {
	    	  if(val%2 == 0) {
	    		  result[start] = val;
	    		  start++;
	    	  }else {
	    		  result[end] = val;
	    		  end--;
	    	  }
		  }
         return result;
	  }
	
	
	public static void  pushZerosToEnd(int arr[]){
		int nz=0;
       
	for (int i = 0; i < arr.length; i++) {
		
		if(arr[i]==0){
			//System.out.println(" i is "+i);
		    nz = getNonZeroIndex(arr,i);
		   // System.out.println("Z is "+nz);
			ArrayUtils.swap(arr, i, nz);
			//{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
			//{1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
		}
		
	}
	
	}
	
	public static int getNonZeroIndex(int arr[],int z){
		
		for (int i = z; i < arr.length; i++) {
			if(arr[i]!=0){
				z=i;
				break;
			}
		}
		
		return z;
		
	}
	
	
	//another approch
	public static void pushZerosToEndCountMethod(int arr[]){
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0){
				arr[count++]=arr[i];
			}
		}
		for (int i = count; i < arr.length; i++) {
				arr[i]=0;
		}
		
		
	}
	
	
	
	
	
	
}
