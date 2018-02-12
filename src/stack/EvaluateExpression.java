package stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {
	
	/*
	 * https://www.hackerrank.com/contests/cs1300-odd-2014/challenges/evaluate-expression
	 * 
	 * INPUT

      ((3+(4/2))*(5+6))        postfix 342/+56+*
      55
	 * 
	 *( (5 + 2 )*(4+1))
	 * 
	 */
	
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
		 String infix = in.nextLine();
		 infix = infix.trim().replaceAll("\\s", "");
		 if (!isValid(infix)) {
	            System.out.println("ERROR");
	            return ;
	        }
		// String postfix = InfixToPostfix.getPostFix(infix);
		// System.out.println(postfix);
		// System.out.println(evaluatePostfix(postfix));
		 System.out.println(calculateExpression(infix));
	}
	 
	 
	 
	   // liner using two stack
	   public static long calculateExpression(String infix) {
		   
		   Stack<Long> operandStack = new Stack<>();//numbers
	       Stack<Character> operatorStack = new Stack<>(); // +,-,/,*.(,)
	       for (char c : infix.toCharArray()) {
				if (Character.isDigit(c)) {
					operandStack.push((long) Character.getNumericValue(c));
				}
				// If the scanned character is an ')', pop and output from the stack
				// until an '(' is encountered.
				else if (c == ')') {
					while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
						Long b = operandStack.pop();
						long a =  operandStack.pop();
						Character operator = operatorStack.pop();
						operandStack.push(getResult(a, b, operator));
					}
					operatorStack.pop();
					
				} else{
					operatorStack.push(c);
				}
	       }
	       
	   	// pop all the operators from the stack
			while (!operatorStack.isEmpty()) {
			//	sb.append(stack.pop());
			}
		   
		   return operandStack.peek();
	   }
	 
	 
	 
	 public static int evaluatePostfix(String postfix){
			Stack<Integer> stack = new Stack<>();
			for (char c : postfix.toCharArray()) {
				if(Character.isDigit(c)){
				//	System.out.println(c + " :"+(int) c);
					stack.push(Character.getNumericValue(c));
				}else{
					long b = stack.pop();
					long a = stack.pop();
				    stack.push((int)getResult( a,  b , c));
				}	
			//	System.out.println(stack);
			}
		 return stack.peek();
	 }



	private static long getResult(long a, Long b, char operation) {
		long result = 0;
		switch (operation)
        {
         case '+': result  = a + b; 
         break;
         case '-': result  = a - b;
         break;
         case '*': result  = a * b; 
         break;
         case '/': result  = a / b;  
         break;
        }
		return result;
	}
	
	public static boolean isValid(String brc) {
		
		HashSet<Character> validCharactersSet = new HashSet<>();
        validCharactersSet.add('*');
        validCharactersSet.add('+');
        validCharactersSet.add('-');
        validCharactersSet.add('/');
        validCharactersSet.add('%');
        validCharactersSet.add('(');
        validCharactersSet.add(')');
        
        HashSet<Character> validoperatorSet = new HashSet<>();
        validoperatorSet.add('*');
        validoperatorSet.add('+');
        validoperatorSet.add('-');
        validoperatorSet.add('/');
        validoperatorSet.add('%');
        
        
        
        
        
		char[] carr = brc.toCharArray();
		Stack<Character> stack = new Stack<>();
		Stack<Character> operatorstack = new Stack<>();
		try {
			for (int i = 0; i < carr.length; i++) {
				char c = carr[i];
				//System.out.println("STACK IS" +stack);
				if (!Character.isDigit(c) && !validCharactersSet.contains(c)) {
					//System.out.println("Returning for "+c);
			        return false;
			    }
				if(validoperatorSet.contains(c)){
					operatorstack.push(c);
				}
				if(!operatorstack.isEmpty() && Character.isDigit(c)){
					operatorstack.pop();
				}
				if (bracketMap.containsKey(c)) {
					//System.out.println("pushing:"+bracketMap.get(c));
					stack.push(bracketMap.get(c));
				} else if (stack.isEmpty()) {
					//System.out.println("retuning from stack 1");
					return false;
				} else if (c == ')') {
			            if (stack.isEmpty()) {
			                return false;
			            }
			            
			            stack.pop();
			        }
				
			}
		} catch (Exception e) {
			return false;
		}
		if(!operatorstack.isEmpty()){
			System.out.println("not valid operator:"+operatorstack);
			return false;
		}
		
		//System.out.println("stack is empty");
		return stack.empty() ? true : false;
	}
	 
	 

}
