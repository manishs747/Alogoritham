package heap;

import java.util.Arrays;

import utils.ArrayUtils;

public class MinHeap {
	
	private int capacity = 10;
	private int size = 0;
	private int items[]  = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex){
		return 2*parentIndex + 1;
	}
	private int getRightChildIndex(int parentIndex){
		return 2*parentIndex + 2;
	}
	private int getParentIndex(int childIndex){
		return (childIndex - 1)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index){
		return items[getLeftChildIndex(index)];
	}
	
    private int rightChild(int index){
    	return items[getRightChildIndex(index)];
	}
    
    private int parent(int index){
    	return items[getParentIndex(index)];
	}
    
    private void swap (int indexOne , int indexTwo){
    	int temp = items[indexOne];
    	items[indexOne] = items[indexTwo];
    	items[indexTwo] = temp;
    }
    
    private void ensureCapacity(){
    	if(size == capacity){
    		capacity = 2 * capacity;
    		items = Arrays.copyOf(items, capacity);
    	}
    }
    
    public int peek(){
    	if(size == 0)
    		throw new IllegalStateException();
    	return items[0];
    }
   
    public void add(int n){
    	ensureCapacity();
    	items[size++] = n;
    	heapifyUp();
    }
   
     private void heapifyUp(){
    	 int index = size -1;
    	 while(hasParent(index) && parent(index) > items[index]){
    		 ArrayUtils.swap(items,index,getParentIndex(index)); //	 swap(index, getParentIndex(index));
    		 index = getParentIndex(index);
    	 }
    }
 	/******************************************************************************************************************/  
     public int pop(){
     	if(size == 0)
     		throw new IllegalStateException();
     	int item = items[0];
     	items[0] = items[--size];
     	heapifyDown();
     	return item;
     }
    
     private void heapifyDown(){
    	 int index = 0;
    	 while(hasLeftChild(index)){
    		 int smallerChildIndex = getLeftChildIndex(index);
    		 if(hasRightChild(index) && rightChild(index) < leftChild(index)){
    			 smallerChildIndex = getRightChildIndex(index);
    		 }
    		 if(items[index] > items[smallerChildIndex]){
    			 swap(index, smallerChildIndex);
    		 }else{
    			 break;
    		 }
    		 index = smallerChildIndex;
    	 }
     }
    
    
	

}
