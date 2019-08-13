package Array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //  int arr [] = {4,5,2,25};
        int arr1 []  = {30,40,70,50,60,20};
    
      //  printNextGreater(arr1);
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int [] arr = new int [size];
        for(int i = 0;i < arr.length;i++) {
        	arr[i] = in.nextInt();
        }
        nextGreaterElement(arr);
        
	}
	
	public static void nextGreaterElementN2(int [] arr){
		 
		for(int i = 0;i<arr.length;i++){
		  int max = -1;
		  for(int j = i+1;j < arr.length;j++){
		   if(arr[j] > arr[i]){
		    max = arr[j];
		    break;
		  }
		  System.out.println(max);
		 }

		}
	}

	
	
	
	static void printNextGreater(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int max = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					max = arr[j];
					break;
				}
			}
			System.out.print(max + " ");
		}
	}
	
	public static void nextGreaterElement(int [] arr){
		if(arr.length == 0){
			return ;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int current = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(arr[i]>current){
				stack.add(arr[i]);
			}
			current = arr[i];
		}
		stack = reverseStack(stack);
		int max = -1;
		for(int i = 0;i<arr.length-1;i++){
			current = arr[i];
			if(current == stack.peek()){
				stack.pop();
			}
			if(current < stack.peek() ){
				max = stack.peek();
			}else{
				max = -1;
			}
			System.out.println(max);
		}
		System.out.println(-1);
	}


	public static  Stack<Integer> reverseStack(Stack<Integer> stack){
		Stack<Integer> newStack  = new Stack<Integer>();
		while(!stack.isEmpty()){
			newStack.push(stack.pop());
		}
		return newStack;
	}


}
