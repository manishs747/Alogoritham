package String;

import java.util.Scanner;
import java.util.Stack;

import org.apache.commons.lang3.ArrayUtils;

import opennlp.tools.util.StringUtil;

public class Reverse {

	public static void main(String[] args) {
	  System.out.println(reverseJava("((((([{()}[]]{{{[]}}})))))"));
	}
	
	
	public String reverseString(String A) {
		char str[] = A.toCharArray();
		for(int i= 0 ,j = str.length-1;i<j;i++,j--) {
			char tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
		}
		return str.toString();
	}
	
	
	//reverse each word in a string
	//https://leetcode.com/problems/reverse-words-in-a-string-iii/
	
	 public String reverseWords(String s) {
		 String[] array = s.split(" ");
		 StringBuilder sb = new StringBuilder();
		 for (String word : array) {
			 sb.append(reverseChar(word));
			 sb.append(reverseChar(" "));
		 }
		return sb.toString().trim();
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
