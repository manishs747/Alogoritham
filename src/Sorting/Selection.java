package Sorting;

import java.util.Scanner;

import Array.Utility;
import Utils.ArrayUtils;

/*
 * 
5
5 4 1 2 3
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
		
		selectionSort(arr);
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
}
