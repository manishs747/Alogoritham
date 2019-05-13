package Sorting;


import utils.ArrayUtils;

public class Main {
	
	public static void main(String[] args) {
		//int A[] = {5,4,1,3,2};
		int A[] = {1,3,55};
		int B[] = {2,4,6,8,10};
		
		
	//	ArrayUtils.print(mergeTwoSortedArray(A, B));
		
		int[] arr = {1,3,5,2,4,6};
		mergeHalf(arr ,new int [arr.length], 0, arr.length-1);
		ArrayUtils.print(arr);

	}
	
	
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
		System.arraycopy(arr, left, result, index, leftEnd - left+1);
		System.arraycopy(arr, index, result, index, rightEnd - right+1);
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
			int val = 0;
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
	
	
	
	public static int[] mergeTwoSortedArrayOld(int [] firstArr ,int[] secondArr){
		int firstLenght  = firstArr.length;
		int secondLenght = secondArr.length;
		int l = firstLenght + secondLenght;
		int [] result = new int [l];
		int first = 0;
		int second = 0;
		for (int i = 0; i < result.length; i++) {
			int val = 0;
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

}
