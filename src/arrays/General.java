package arrays;

import utils.ArrayUtils;

public class General {
	
	
	public static void main(String[] args) {
		int[] iArray =  {101,102,103,104,105};
		String[] sArray = new String[] {"one", "two", "three", "four", "five"};
		reverse(iArray);
		ArrayUtils.print(iArray);

	}
	
	public static void reverse(int arr[]){
		for (int i = 0,j=arr.length-1; i < (arr.length/2); i++,j--) {
			ArrayUtils.swap(arr, i, j);
		}
		
	}
	
	public static void rotate(int arr[],int n){
		
	}

}
