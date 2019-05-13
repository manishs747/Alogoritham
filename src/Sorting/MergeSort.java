package Sorting;

import Array.Utility;
import utils.ArrayUtils;

public class MergeSort {

	public static void main(String[] args) {
		//int arrOne[] = {1,3,5,7};
		//int arrTwo[]={2,4,6,8,9,11,12};
		//Utility.print(mergeTwoSortedArray(arrOne, arrTwo));

		int A[] = {5,4,1,3,2};
		mergeSort(A, 0, A.length-1);
		ArrayUtils.print(A);
	}

	private static void mergeSort(int[] a, int leftStart, int rightEnd) {
		if (leftStart < rightEnd) {

			int middle = (leftStart + rightEnd) / 2;
			mergeSort(a, leftStart, middle);
			mergeSort(a, middle+1, rightEnd);
			mergeHalf(a,new int [a.length],leftStart,rightEnd);
		}
	}


	//https://www.geeksforgeeks.org/merge-two-sorted-arrays/

	private static void mergeHalf(int[] arr, int [] result, int leftStart, int rightEnd) {
		int leftEnd  =  ( leftStart+rightEnd )/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while( left <= leftEnd && right <= rightEnd) {
			if(arr[left]  <= arr[right] ) {
				result[index++] = arr[left++];
			}else {
				result[index++] = arr[right++];
			}
		}
		System.arraycopy(arr, left, result, index, leftEnd - left+1); //  only one of the copy will work from this and below
		System.arraycopy(arr, index, result, index, rightEnd - right+1);//
		System.arraycopy(result, leftStart, arr, leftStart, size);

	}

	public static int[] mergeTwoSortedArrays(int [] firstArr ,int[] secondArr){
		int firstLenght  = firstArr.length;
		int secondLenght = secondArr.length;
		int l = firstLenght + secondLenght;
		int [] result = new int [l];
		int first = 0;
		int second = 0;
		for (int i = 0; i < result.length; i++) {
			int val = Integer.MIN_VALUE;
			if (first < firstLenght) {
				val = firstArr[first];
			}
			if (second < secondLenght && val > secondArr[second]) {
				val = secondArr[second++];
			}else {
				first++;
			}
			result[i] = val;
		}
		return result;
	}



	public static int[] mergeTwoSortedArray(int [] arrOne ,int[] arrTwo){
		int lenthOne = arrOne.length;
		int lengthTwo = arrTwo.length;
		int [] result = new int[lenthOne+lengthTwo];
		int one = 0;
		int two = 0;
		int i = 0;
		while(one < lenthOne && two < lengthTwo){
			if(arrOne[one] < arrTwo[two]){
				result[i++] = arrOne[one++];
			}else{
				result[i++] = arrTwo[two++];
			}
		}
		int left  = one;
		int [] arr = arrOne ;

		if(two < lengthTwo){
			left = two;
			arr = arrTwo ;
		}
		for (; i < lenthOne+lengthTwo; i++) {
			result[i] = arr[left++];
		}
		return result;
	}

}
