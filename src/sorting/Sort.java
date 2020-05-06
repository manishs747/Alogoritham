package sorting;

import utils.ArrayUtils;

public class Sort
{
	
	int [] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort s = new Sort();
		int A[] = {5,4,1,3,2};
		//Arrays.sort(A);
		
		ArrayUtils.print(A);
	//	s.MergeSort(A,0,A.length-1);
		//ArrayUtils.countSort(A, 5);
		//print(A);
		
		int Q[] = {3,4,1,5};
		
		//quickSort(Q, 0, 3);
		//quicksort(Q);
	//	ArrayUtils.print(Q);
		
	}
	

	


	
	
	
	public static void quicksort(int [] array){
		quicksort(array, 0, array.length - 1);
	}
	
    public static void quicksort(int [] array,int left , int right){
    	if(left >= right){
    		return;
    	}
    	int pivot = array[(left + right )/2];
    	int index  = partioned(array,left,right,pivot);
    	quicksort(array, left, index -1);
    	quicksort(array, index, right);
    	
		
	}


	private static int partioned(int[] array, int left, int right, int pivot) {
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
	
	
	public static void mergesort(int [] array){
		mergesort(array, new int[array.length],0, array.length -1);
	}
	
    public static void mergesort(int [] array,int [] tmp ,int left , int right){
    	if(left >= right){
    		return;
    	}
    	int mid = (left + right)/2;
    	mergesort(array,tmp, left, mid);
    	mergesort(array,tmp, mid+1, right);
    	mergeHalves(array,tmp ,left , right);
    	
	}


	private static void mergeHalves(int[] array, int[] tmp, int leftStart,
			int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				tmp[index] = array[left];
				left++;
			} else {
				tmp[index] = array[right];
				right++;
			}
			index++;
		}
    
		// only one of the two will be applied
		System.arraycopy(array, left, tmp, index, leftEnd - left + 1); 
		System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
		System.arraycopy(tmp, leftStart, array, leftStart, size);// copy from
																	// tmp to
																	// array

	}
	
	
	public static void insertsort(int[] array){
		
		
	}
	
	
	

}
