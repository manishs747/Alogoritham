package heap;

import org.apache.commons.lang3.ArrayUtils;

import Array.Utility;

public class HeapSrt {

	public static void main(String[] args) {
		int [] arr = { 7,6,3,2,1,5,4};
		heapSort(arr);
		Utility.print(arr);
	}
	//similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.
	// To heapify a subtree rooted with node i which is
	// an index in arr[]. size is size of heap  max heap
	private static void heapSort(int[] arr) {
		buildMaxHeap(arr);  //preassumption  in order to heapify to work both children should follow heap property.
		Utility.print(arr);
		for (int i = arr.length-1; i > 0; i--) {
			int pop = pop(arr,i);
			arr[i] = pop;
			heapifyDown(arr,0,i);
		}
	}

	public static int pop(int [] items,int size){
		if(size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size];
		return item;
	}


	private static void buildMaxHeap(int[] arr) {
		int n = getParentIndex(arr.length-1);
		for (int i = n; i >= 0; i--) {
			heapifyDown(arr,i,arr.length);
		}
	}

	//size is size of array
	private static void heapifyDown(int[] arr,int index,int size) {
		while(hasLeftChild(index,size)) {
			int largerChildIndex = getLeftChildrenIndex(index);
			if (hasRightChild(index, size) && rightChild(arr,index) > hasLeftChild(arr,index) ) {
				largerChildIndex = getRightChildrenIndex(index);
			}
			if (arr[index] > arr[largerChildIndex]) {
				break;
			}else {
				ArrayUtils.swap(arr, index, largerChildIndex);;
			}
			index = largerChildIndex;
		}
	}

	private static int hasLeftChild(int[] arr, int index) {
		return arr[getLeftChildrenIndex(index)];
	}
	private static int rightChild(int [] arr,int index) {
		return arr[getRightChildrenIndex(index)];
	}
	private static boolean hasLeftChild(int index, int size) {
		return getLeftChildrenIndex(index) < size;
	}

	private static boolean hasRightChild(int index, int size) {
		return getRightChildrenIndex(index) < size;
	}

	private static int getLeftChildrenIndex(int i) {
		return 2*i+1;
	}

	private static int getRightChildrenIndex(int i) {
		return 2*i + 2;
	}

	private static int getParentIndex(int i) {
		return (i-1)/2;
	}

}
