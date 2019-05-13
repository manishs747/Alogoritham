package Sorting;

import utils.ArrayUtils;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {5,4,1,3,2};
		quickSort(A, 0, A.length-1);
		ArrayUtils.print(A);

	}
	
	
	public static void quickSort(int[] A, int l, int h) {
		if (l < h) {
			int p = partion(A, l, h);
			quickSort(A, l, p - 1);
			quickSort(A, p + 1, h);
		}
	}
	
	//as per cormen partioned
	public static int partion(int[] A, int l, int h) {
		int pivot = A[h];
		int i = l - 1;
		for (int j = l; j < h; j++) {
			if (A[j] < pivot) {
				i = i + 1;
				ArrayUtils.swap(A, i, j);
			}
		}
		ArrayUtils.swap(A, i + 1, h);
		return i + 1;
	}
	

	
	public static void quickSorted(int[] A, int l, int h) {
		if (l < h) {
			int p = partioned(A, l, h);
			quickSort(A, l, p - 1);
			quickSort(A, p , h);
		}
	}
	
	
	private static int partioned(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while(left< right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			ArrayUtils.swap(array, left, right);
		}
		return left;
	}
	
	//as per HackerRank partioned
	public static int partionedother(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				ArrayUtils.swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	
	
	
	

}
