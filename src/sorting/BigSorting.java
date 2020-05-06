package sorting;

import java.math.BigInteger;
import java.util.Scanner;

/*
 https://www.hackerrank.com/challenges/big-sorting
6
31415926535897932384626433832795
1
3
10
3
5
 */
public class BigSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] unsorted = new String[n];
	        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
	            unsorted[unsorted_i] = in.next();
	        }
	        
	        selectionSort(unsorted);
	        printarr(unsorted);

	}
	
	
	private static void printarr(String[] unsorted) {
		// TODO Auto-generated method stub
		for (String str : unsorted) {
			System.out.println(str);
		}
		
	}


	public static void selectionSort(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, getMin(arr, i));
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}


	private static int getMin(String[] arr, int i) {
		int minIndex = i;
		for (i = i + 1; i < arr.length; i++) {
			if (new BigInteger(arr[minIndex]).compareTo(new BigInteger(arr[i])) == 1) {
				minIndex = i;
			}
		}
		return minIndex;
	}

}
