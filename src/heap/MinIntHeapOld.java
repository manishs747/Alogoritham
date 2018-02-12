package heap;

import java.util.Arrays;

import LinkList.Node;

public class MinIntHeapOld {
	private int capacity = 10;
	private int size = 0;
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex){
		return 2*parentIndex + 1;
	}
	private int getRightChildIndex(int parentIndex){
		return 2*parentIndex + 2;
	}
	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	
	private boolean hasLeftChild(int index){
		return getLeftChildIndex(index) < size;
	}
	private boolean hasRightChild(int index){
		return getRightChildIndex(index) >= 0;
	}
	private boolean hasParent(int index){
		return getParentIndex(index) >= 0;
	}
	
	private int LeftChild(int index){
		return items[getLeftChildIndex(index)];
	}
	private int RightChild(int index){
		return items[getRightChildIndex(index)];
	}
	private int Parent(int index){
		return items[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int tmp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] =  items[indexOne];
	}
	
	private void ensureCapacity(){
		if(size == capacity){
			capacity =  capacity * 2;
			items = Arrays.copyOf(items,capacity);
		}
	}
	
	public int peek(){
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int data){
		ensureCapacity();
		items[size] = data;
		size++;
	    heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && Parent(index) > items[index]){
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown(){
      int index = 0;
      while(hasLeftChild(index)){
    	  int smallerChildIndex = getLeftChildIndex(index);
    	  if(hasRightChild(smallerChildIndex) && RightChild(index) > LeftChild(index)){
    		  smallerChildIndex = getRightChildIndex(index);
    	  }
    	  if(items[index] < items[smallerChildIndex] ){
    		  break;
    	  }else{
    		  swap(index, smallerChildIndex);
    	  }
    	  index = smallerChildIndex;
      }
      
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
