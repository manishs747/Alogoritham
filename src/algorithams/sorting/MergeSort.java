package algorithams.sorting;

import data_structure.arrays.Utility;

public class MergeSort {
	
	public static void main(String[] args) {
		int arrOne[] = {1,3,5,7};
		int arrTwo[]={2,4,6,8,9,11,12};
		Utility.print(mergeTwoSortedArray(arrOne, arrTwo));
		
		//mergeSort(A, 0, A.length-1);
		//ArrayUtils.print(A);
	}

	private static void mergeSort(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	//https://www.geeksforgeeks.org/merge-two-sorted-arrays/
	
	
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
		
		System.out.println("Left Index:"+one+" Right Index:"+two);
		int left  = one;
		int [] leftarray = arrOne ;

		if(two < lengthTwo){
			left = two;
			leftarray = arrTwo ;
		}
		for (; i < lenthOne+lengthTwo; i++) {
			result[i] = leftarray[left++];
		}

		return result;
	}

}
