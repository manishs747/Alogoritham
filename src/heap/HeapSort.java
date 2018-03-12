package heap;

import java.util.Arrays;

import Array.Utility;
import LinkList.Node;

public class HeapSort {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = { 7,6,3,2,1,5,4};
		heapSort(arr);
		Utility.print(arr);

	}
	
	
	// main function to do heap sort
	static void heapSort(int arr[])
	{
		int length = arr.length;
		int lastIndex = length - 1;
		// Build heap (rearrange array)
		int parentIndexLastNode = getParentIndex(lastIndex);
		for (int i = parentIndexLastNode; i >= 0; i--){
			heapifyDown(arr, lastIndex, i);
		}
		// One by one extract an element from heap
		for (int i=lastIndex; i>=0; i--)
		{
		   // Move current root to end
			swap(arr,0, i);
			// call max heapify on the reduced heap
			heapifyDown(arr, i, 0);
		}	
	}
		
	
	
	
	// To heapify a subtree rooted with node i which is
	// an index in arr[]. size is size of heap  max heap
		static void  heapifyDown(int arr[], int size, int index){
		while (hasLeftChild(index, size)) {
			int biggerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index, size) && arr[getRightChildIndex(index)] > arr[getLeftChildIndex(index)]) {
				biggerChildIndex = getRightChildIndex(index);
			}
			if (arr[index] < arr[biggerChildIndex]) {
				swap(arr, index, biggerChildIndex);
				index = biggerChildIndex;
			} else {
				break;
			}
		}
	}
	
	
	private static void swap(int[] items, int indexOne, int indexTwo) {
		int temp = items[indexOne];
    	items[indexOne] = items[indexTwo];
    	items[indexTwo] = temp;
		
	}



	private  static boolean hasRightChild(int index, int size) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean hasLeftChild(int index,int size) {
	   return getLeftChildIndex(index) < size;
	}
	
	private  static int getLeftChildIndex(int parentIndex){
		return 2*parentIndex + 1;
	}
	private static int getRightChildIndex(int parentIndex){
		return 2*parentIndex + 2;
	}
	private static int getParentIndex(int childIndex){
		return (childIndex - 1)/2;
	}



	

}
