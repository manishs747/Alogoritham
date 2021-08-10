package algorithams.sorting;

import utils.ArrayUtils;


/**
 * https://www.youtube.com/watch?v=KF2j-9iSf4Q
 */
public class MergeSort {
	
	public static void main(String[] args) {
	/*	int arrOne[] = {1,3,5,7};
		int arrTwo[]={2,4,6,8,9,11,12};
		Utility.print(mergeTwoSortedArray(arrOne, arrTwo));*/
		int [] nums = {5,1,1,2,0,0};
		sort(nums);
		ArrayUtils.print(nums);
	}

	public static void sort(int[] array){
		mergeSort(array,new int [array.length],0,array.length-1);
	}

	private static void mergeSort(int[] array,int [] tmp, int leftStart, int rightEnd) {
       if(leftStart >= rightEnd){
       	 return;
	   }
       int middle = (rightEnd+leftStart)/2;
       mergeSort(array,tmp,leftStart,middle);//left  half
       mergeSort(array,tmp,middle+1,rightEnd); //right half
	   mergeHalves(array,tmp,leftStart,rightEnd);
	}

	private static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd+leftStart)/2;
		int rightStart = leftEnd+1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while (left <= leftEnd && right <= rightEnd){
			tmp[index++] = array[left] <= array[right] ? array[left++]: array[right++];
		}
        System.arraycopy(array,left,tmp,index,leftEnd-left+1);
		System.arraycopy(array,right,tmp,index,rightEnd-right+1);
		System.arraycopy(tmp,leftStart,array,leftStart,rightEnd -leftStart+1);
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
