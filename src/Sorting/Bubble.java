package Sorting;

import java.util.Scanner;

import Utils.ArrayUtils;
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
       
		int count  = BubbleSortImproved(arr);
		System.out.println("Array is sorted in "+count+" swaps.");
		System.out.println("First Element: "+arr[0]);
		System.out.println("Last Element: "+arr[len-1]);
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
