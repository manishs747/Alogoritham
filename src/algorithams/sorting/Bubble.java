package algorithams.sorting;

import utils.ArrayUtils;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
/*
3
3 2 1
 */
public class Bubble {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int arr[] = new int [len];
		for (int i = 0; i < len; i++) {
			arr[i] = in.nextInt();
		}
		BubbleSortImproved(arr);
		ArrayUtils.print(arr);
	}

	//lovely Best HackerRank
	/*
	 * https://www.youtube.com/watch?v=6Gv8vg0kcHc
	 */
	public static void BubbleSortImproved(int[] arr){
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

	void bubbleSort(int arr[]) {
		int len = arr.length;
		for (int i = len-1; i >= 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					ArrayUtils.swap(arr, j, j + 1);
				}
			}
		}
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
	


}
