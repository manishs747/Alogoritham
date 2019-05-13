package Sorting;

import java.util.Scanner;

import utils.ArrayUtils;
//https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
/*
3
3 2 1
 */
public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int arr[] = new int [len];
		for (int i = 0; i < len; i++) {
			arr[i] = in.nextInt();
		}
       
		 bubbleSortHackerRank(arr);
		ArrayUtils.print(arr);
	}
	
	

	public static  void BubbleSort(int[] A) {
		int len = A.length;
		for (int i = 0; i < len -1 ; i++) {
			for (int j = len -1 ; j > i ; j--) {
				if (A[j] < A[j - 1]) {
					ArrayUtils.swap(A, j, j - 1);
				}
			}
		}
	}
	
	void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					ArrayUtils.swap(arr, j, j + 1);
				}
			}
			ArrayUtils.print(arr);
		}
	}
	
	//lovely
	/*
	 * https://www.youtube.com/watch?v=6Gv8vg0kcHc
	 */
	public static void bubbleSortHackerRank(int[] arr){
		boolean isSorted = false;
		int  lastUnsorted = arr.length-1;
		while(!isSorted){
			isSorted = true;
			for (int i = 0; i < lastUnsorted; i++) {
				if(arr[i] > arr[i+1]){
					ArrayUtils.swap(arr, i, i+1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}
	
	public static int BubbleSortImproved(int[] A) {
		boolean swapped = true;
		int len = A.length;
		int count = 0;
		for (int i = 0; i < len -1 && swapped; i++) {
			swapped = false;
			for (int j = len - 1; j > i; j--) {
				if (A[j] < A[j - 1]) {
					ArrayUtils.swap(A, j, j - 1);
					swapped = true;
					count++;
				}
			}
		}
		return count ;
	}

}
