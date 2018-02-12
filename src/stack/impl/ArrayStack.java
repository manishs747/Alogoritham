package stack.impl;

import java.util.Arrays;

public class ArrayStack {
	private int top;
	private int capacity;
	private int [] array;
	public ArrayStack(int capacity) {
		top = -1;
		this.capacity = capacity;
		array = new int [capacity];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isStackfull(){
		return (top == capacity -1);
	}
	
	 private void grow() {
	        // overflow-conscious code
	        int newCapacity =  array.length*2;
	        array = Arrays.copyOf(array, newCapacity);
	    }
	 
	 private void ensureCapacityHelper() {
	        // overflow-conscious code
	        if (top+1 - array.length > 0){
	        	 grow();
	        }
	    }
	 
	 public void push(int data){
			ensureCapacityHelper();
			array[++top] = data;
		}
	 
	 public int pop(){
			if(isEmpty()){
				System.out.println("Stack is Empty");
				return 0;
			}else{
				return array[top--];
			}
		}
	 public int peek(){
			if(isEmpty()){
				System.out.println("Stack is Empty");
				return 0;
			}else{
				return array[top];
			}
		}

}
