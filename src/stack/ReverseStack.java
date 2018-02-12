package stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		List<Integer> list = new ArrayList<Integer>(stack);
		System.out.println(list);
		System.out.println(stack);
		/*stack = reverseCollection(stack);
		System.out.println(stack);*/
		
	}
	
	public static void  reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int num = stack.pop();
	//	System.out.println(num);
		reverse(stack);
		System.out.println(num);
		stack.push(num);
	}
	
	
	public static Stack<Integer> reverseCollection(Stack<Integer> oldStack){
		Collections.reverse(oldStack);
		return oldStack;
	}
	
	
	public static Stack<Integer> reverseStack(Stack<Integer> oldStack){
		Stack<Integer> reversedStack = new Stack<Integer>();
	    while (!oldStack.empty())
	    {
	        reversedStack.push(oldStack.pop());
	    }
	    return reversedStack;
	}
	

}
