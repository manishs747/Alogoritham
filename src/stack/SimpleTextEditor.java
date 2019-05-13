package stack;

import java.util.Scanner;
import java.util.Stack;


/*
   https://www.hackerrank.com/challenges/simple-text-editor/problem
   
   
    append - Append string to the end of .
    delete - Delete  the last k  characters of .
    print - Print the character of .
    undo - Undo the last (not previously undone) operation of type or , reverting to the state it was in prior to that operation.



   input
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1

output
c
y
a


 * 
 * 
 * 
 * 
 * 
 */

public class SimpleTextEditor {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int action = in.nextInt();
			if (action == 1 ) {
				String appendStr = in.next();
				textEditor(sb,s,action, appendStr, -1);
			} else if (action == 4) {
				textEditor(sb,s,action, "", -1);
			} else {
				int param = in.nextInt();
				textEditor(sb,s,action, "", param);
			}  
		}
	}
	
	public static void textEditor(StringBuilder sb,Stack<String> s, int action , String str , int param ) {
		//System.out.println(sb.toString() + " ACTION:"+action+ " STR:"+str);
		
		if (action == 1 ) {
			sb.append(str);
			s.push(sb.toString());
		} else if (action == 4) {
			s.pop();
			sb.setLength(0);
			if (!s.empty()) {
				sb.append(s.peek());
			}
		//	System.out.println("REMOVED:"+sb.toString()+" Stack:"+s);
		} else if (action == 2) {//delete last k element
			sb.delete(sb.length()-param, sb.length());
			s.push(sb.toString());
		}  else if (action == 3) { //print
			System.out.println(sb.toString().charAt(param-1));
		}
	}
	
	

	

}
