package mock;

import java.util.ArrayList;
import java.util.List;

import utils.ArrayUtils;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.
Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
	 */
	  public String[] reorderLogFiles(String[] logs) {
		  List<String> digit = new ArrayList<>();
		  List<String> letter = new ArrayList<>();
		  for (String val : logs) {
			  if (isDigit(val)) {
				  digit.add(val);
			  }else {
				  letter.add(val);
			  }
		   }
		  BubbleSort(letter);
		  String[] resultLog = new String[logs.length];
		  int i = 0;
		  for (String val:letter) {
			  resultLog[i] = val;
			  i++;
		}
		  for (String val:digit) {
			  resultLog[i] = val;
			  i++;
		}
		return resultLog; 
	    }
	  
	
	 
		public static  void BubbleSort(List<String> A) {
			int len = A.size();
			for (int i = 0; i < len -1 ; i++) {
				for (int j = len -1 ; j > i ; j--) {
					if (isSmaler(A.get(j), A.get(j-1))) {
						swap(A, j, j - 1);
					}
				}
			}
		}
	 
	 private static void swap(List<String> A, int j, int i) {
			String t = A.get(j);
			A.set(j, A.get(i));
			A.set(i, t);
		}

	public static boolean isSmaler(String s1 ,String s2) {
		 s1= s1.substring( s1.indexOf(" "),s1.length()); 
		 s2= s2.substring( s2.indexOf(" "),s2.length());
	
		 if (s1.compareTo(s2) > 0) {
			 return true;
		 }
		return false;
	 }
	  
	  public static boolean isDigit(String val) {
		String[] arr = val.split(" ");
		char c  =  arr[1].charAt(0);
		return Character.isDigit(c);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	/*  n = 3
	 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

	 */
	 public List<String> generateParenthesis(int n) {
		 
		 
		 
		return null;
	        
	    }

}
