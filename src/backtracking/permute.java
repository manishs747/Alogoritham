package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class permute {
	public static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = "ABC"; 
		 permuteArr(str.toCharArray());

	}
	
	
	public static void permuteArr(char [] arr) {
		permuteArr(arr,0,arr.length-1);
		
	}
	
	private static void permuteArr(char [] array,int l,int r) {
		if (l == r) {
			System.out.println(array);
			return;
		} 
		for (int i = l; i <= r; i++) {
			Array.Utility.swap(array, l, i);	
			permuteArr(array,l+1,r);
			Array.Utility.swap(array, l, i);
		}
	}
	
	
	public static void permuteArr(int [] arr) {
		permuteArr(arr,0,arr.length-1);
	}
	
    private static void permuteArr(int[] arr, int l, int r) {
    	
		
    	
	}


	public static void swap(int[] array,int i ,int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
