package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * https://www.interviewbit.com/problems/evaluate-expression/
 * https://www.hackerrank.com/contests/cs1300-odd-2014/challenges/evaluate-expression/problem
 * 
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/

 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 */

public class EvaluateExpressionNew {

	// primitive type) 


	// Set demonstration using HashSet Constructor 
	static Set<String> set ;
	static
	{
		set = new HashSet<>();
		set.add("+");
		set.add("-");
		set.add("*");
		set.add("/");
	}



	public static void main(String[] args) {
		String [] A = {"4", "13", "5", "/", "+"};
		List<String> list =  Arrays.asList(A);
		int result = evalRPN(list);
		System.out.println(result);

	}

	
	//working
	public static int evalRPN(List<String> A) {
		Stack<String> stack = new Stack<>();
		for (String val : A) {
			if(set.contains(val)) {
				String second = stack.pop();
				String first = stack.pop();
				stack.push(operation(first, second, val));
			}else {
				stack.push(val);
			}
		}
		return Integer.parseInt(stack.peek());
	}

	public static String  operation(String first,String second,String operation) {
		int f = Integer.parseInt(first);
		int s = Integer.parseInt(second);
		int result = 0;
		switch (operation) {
		case "+":
			result = f + s;
			break;
		case "-":
			result = f - s;
			break; 
		case "*":
			result = f * s;
			break;
		case "/":
			result = f / s;
			break;  
		default:
			break;
		}
		return String.valueOf(result);
	}


}
