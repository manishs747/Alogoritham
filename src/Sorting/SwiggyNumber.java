package Sorting;

import java.util.Scanner;
import java.util.Stack;

public class SwiggyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		//System.out.println("manish".substring(0, 0));
		System.out.println(isGoodStrStack(str));
	}
	
	

	public static String isGoodStrStack(String word) {
		Stack<Character> st = new Stack<Character>();
		char[] ch = word.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			Character c = ch[i];
			if (c.equals('a')) {
				st.push('a');
			} else if (!st.empty() && c.equals('b')) {
				st.pop();
			} else {
				return "Bad";
			}
		}
		return (st.isEmpty()) ? "Good" : "Bad";

	}
	
	
	public static String isGoodStr(String word){
		String tmp = word;
		while(tmp.length() > 0){
			if(tmp.contains("ab")){
				tmp = tmp.replace("ab", "");
				System.out.println(tmp);
			}else{
				return "Bad";
			}
		}
		return "Good";
	}
	
	public static String isGoodStrold(String word){
		
	  String tmp = "ab";
	
	  
	  while(tmp.length() <= word.length()){
		  boolean flag = false;
		  for (int i = 0; i < tmp.length(); i++) {
			  
			   String  x = tmp.substring(0, i) + "ab" + tmp.substring(i, tmp.length());
			   if(word.equals(x)){
				   return "Good";
			   }
			   if(word.contains(x)){
				   tmp = x;
				   System.out.println(2+tmp);
				   flag = true;
				   break;
			   }
		}
		  
		  if(flag == false){
			  System.out.println(1+tmp);
			  return "Bad";
		  }else{
			  System.out.println(3+tmp);
			  continue;
		  }
		
	  }
	  System.out.println(tmp);
	  return "Bad";
		
		
	}

}
