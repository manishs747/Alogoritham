package queue;

import java.util.Scanner;
import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 * 
 * Input
 *  10
	1 42
	2
	1 14
	3
	1 28
	3
	1 60
	1 78
	2
	2

output
	14
	14

 * 
 * 
 */

public class QueueUsingTwoStack {


	public static class MyQueue<T>{
		private Stack<T> stackNewOnTop = new Stack<T>();
		private Stack<T> stackOldOnTop = new Stack<T>();

		public void enQueue(T value) {//Add item
			stackNewOnTop.push(value);

		}
		public T poll() {
			shiftStack();
			return stackOldOnTop.pop();
		}
		public T peak() {
			shiftStack();
			return stackOldOnTop.peek();
		}
		
		
		private void shiftStack() {  //stackNewOnTop to stackOldOnTop
			if (stackOldOnTop.isEmpty()) {
				while(!stackNewOnTop.isEmpty()) {
					stackOldOnTop.push(stackNewOnTop.pop());
				}
			}
		}



	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
