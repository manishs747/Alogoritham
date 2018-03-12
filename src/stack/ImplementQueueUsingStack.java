package stack;

import java.util.Stack;
//https://www.youtube.com/watch?v=7ArHz8jPglw&t=8s
/*
 * 
 * dont have to shift stack all the time only when oldOnTop is empty
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
		
	}

}
