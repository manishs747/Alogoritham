package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


// https://www.hackerrank.com/challenges/balanced-brackets?h_r=next-challenge&h_v=zen
/*
3
{[()]}
{[(])}
{{[[(())]]}}

YES
NO
YES


6
}][}}(}][))]
[](){()}
()
({}([][]))[]()
{)[](}]}]}))}(())(
([[)

NO
YES
YES
YES
NO
NO

 * 
 */


public class BalancedBracket {
	
	 private static final Map<Character, Character> bracketMap;
	    static
	    {
	    	bracketMap = new HashMap<Character, Character>();
	    	bracketMap.put('[', ']');
	    	bracketMap.put('{', '}');
	    	bracketMap.put('(', ')');
	    }

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			String s = in.next();
			if(isBalanced(s)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

	}
	
	public static boolean isBalanced(String brc) {
		char[] carr = brc.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < carr.length; i++) {
			char c = carr[i];
			if (bracketMap.containsKey(c)) {
				stack.push(bracketMap.get(c));
			} else if (stack.isEmpty()) {
				return false;
			} else if (c != stack.pop()) {
				return false;
			}
		}
		return stack.empty() ? true : false;
	}

}
