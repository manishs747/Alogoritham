package Hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/maximum-element/problem
/*
 * 1 x  -Push the element x into the stack.
   2    -Delete the element present at the top of the stack.
   3    -Print the maximum element in the stack.
   
   sample input 
10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3

sample output 
26
91
 * 
 */
public class MaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int action = in.nextInt();
			printMax(stack, maxStack, in, action);
		}

	}

	private static void printMax(Stack<Integer> stack, Stack<Integer> maxStack,
			Scanner in, int action) {
		if(action == 1){
			int  num = in.nextInt();
			stack.add(num);
			if(maxStack.isEmpty()){
				maxStack.push(num);
			}
			if(num  >= maxStack.peek()){
				maxStack.push(num);
			}
		}
		if(action == 2){
			 int removed = stack.pop();
			 if(maxStack.peek() == removed){
				 maxStack.pop();
			 } 
		}
		if(action == 3){
			System.out.println(maxStack.peek());
		}
	}

}
