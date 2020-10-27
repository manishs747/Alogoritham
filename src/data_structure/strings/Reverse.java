package data_structure.strings;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        if(A.equals(reverse(A))){
        	System.out.println("Yes");
        }else{
        	System.out.println("NO");
        }
        

	}
	
	public static String reverseJava(String word){
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString();
	}
	
	public static String reverse(String word){
		Stack<Character> st = new Stack<Character>();
		 for (char c : word.toCharArray()) {
			st.push(c);
		}
		 StringBuilder sb = new StringBuilder();
		 while(!st.isEmpty()){
			 sb.append(st.pop());
		 }
		 
		 return sb.toString();
	}
	
	// A stack based function to reverese a string
	public static String reverseChar(String word)
	{
		char str[] = word.toCharArray();
	    // get size of string
	    int n = str.length, i;
	    for (i = 0; i < n/2; i++){
	    	char t = str[i];
	    	str[i] = str[n-i-1];
	    	str[n-i-1] = t;
	    }  
	    
	    return new String(str);
	}

}
