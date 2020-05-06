package stack;

import java.util.Scanner;
import java.util.Stack;
//https://www.youtube.com/watch?v=7ArHz8jPglw&t=8s
/*
 * 
 * dont have to shift stack all the time only when oldOnTop is empty
 * 
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 * 
 * 
 * 
 */
public class ImplementQueueUsingStack {
	public static class MyQueue<T>{
		private Stack<T> stackNewOnTop = new Stack<T>();
		private Stack<T> stackOldOnTop = new Stack<T>();
		
		public void enQueue(T value){
			stackNewOnTop.push(value);
		 }
		
		public T peak(){
			shiftStack();
			return stackOldOnTop.peek();
		}
		
        private void shiftStack() {
        	if(stackOldOnTop.isEmpty()){
        		while(!stackNewOnTop.isEmpty()){
        			stackOldOnTop.push(stackNewOnTop.pop());
        		}
        	}
		}

		public T poll(){
			shiftStack();
			return stackOldOnTop.pop();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyQueue<Integer>  mysque = new MyQueue<Integer>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int option = in.nextInt();
			switch (option) {
			case 1:
				int value = in.nextInt();
				mysque.enQueue(value);
				break;
            case 2:
            	mysque.poll();
				break;
            case 3:
				System.out.println(mysque.peak());
				break;

			default:
				break;
			}
		}
	}

}
