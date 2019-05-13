package Sorting;

import java.util.Scanner;

import Array.Utility;
import utils.ArrayUtils;

/*
 * 
5
2 4 1 5 3

5
1 2 3 4 5
 */
public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int arr[] = new int [len];
		for (int i = 0; i < len; i++) {
			arr[i] = in.nextInt();
		}
	
		selectionSortMax(arr);
		Utility.printArray(arr);

	}
	
	
	
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			ArrayUtils.swap(arr, i, getMin(arr, i));
		}
	}
	
	private static int getMin(int[] arr, int i) {
		int minIndex = i;
		for (i = i + 1; i < arr.length; i++) {
			if (arr[minIndex] > arr[i]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	/******************************************************************************************************************/
	
	public static void selectionSortMax(int[] arr) {
		for (int i = arr.length -1; i > 0; i--) {
			ArrayUtils.swap(arr, i, getMax(arr, i));
		}
	}

	//get max along with i
	private static int getMax(int[] arr, int i) {
		int maxIndex = i;
		for (int j = i-1; j >= 0; j--) {
			if (arr[maxIndex] < arr [j]) {
				maxIndex = j;
			}
		}
		return maxIndex;
	}
	
	
	
	
}
