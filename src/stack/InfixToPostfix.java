package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 * https://www.hackerrank.com/contests/code-maestros-14-04/challenges/baby-step
 * 
 sample input 
4
(a+b)
(a+b*c)
(r+(s+t))
((r+s)+t)

output/
ab+
abc*+
rst++
rs+t+
 */
public class InfixToPostfix {
	
	private static final Map<Character, Integer> precedenceMap;
	static {
		precedenceMap = new HashMap<Character, Integer>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		for (int i = 0; i < size; i++) {
			String infix = in.next();
			String postfix = getPostFix(infix);
			System.out.println(postfix);
		}
	}

	public static String getPostFix(String infix) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char c : infix.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				sb.append(c);
			}
			// If the scanned character is an '(', push it to the stack.
			else if (c == '(')
				stack.push(c);
			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else // an operator is encountered eg * + - / ^
			{
				while (!stack.isEmpty() && getPrec(c) < getPrec(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		// pop all the operators from the stack
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static int getPrec(char c) {
		if (precedenceMap.containsKey(c)) {
			return precedenceMap.get(c);
		} else {
			return -1;
		}
	}

}
