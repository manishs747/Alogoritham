package dynamic_programming;

import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * https://www.youtube.com/watch?v=1iU-WXG-J_Y
 * 
 * https://www.youtube.com/watch?v=Mbav2iuJ7xQ
 * 
 * 
 * forgeeksskeegfor
 * 
 * geeksskeeg
 * 10
 * 
 * 
 * Input: "dcbcf"
   Output: "cbbc"
 * 
 */

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner in = new Scanner(System.in);
		String str = in.next();
		//System.out.println("Your String :"+str);
	//	System.out.println(" Word "+str+" is pal = "+ispal(str));
		//longestPalSubstr(str);
		System.out.println(longestPalindromeDp(str));

	}
	
	static String longestPalSubstr(String s){
		
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			System.out.println("pallend with center:"+s.charAt(i)+" is "+tmp);
		}
		
		return longest;
	}
	
	
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	//startIndex : starting index is inclusive
	//endIndex : ending index is exclusive
	
	public static String helper(String s, int begin, int end) {
		if(end<s.length()-1 && s.charAt(begin)==s.charAt(end+1)){
			end++;
		}
		
		while(begin >=0 && end <= s.length()-1 && s.charAt(begin)==s.charAt(end)){
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
		
	}
	
	static  boolean ispal(String str){
		return str.equals(new StringBuilder(str).reverse().toString())  ? true : false;
	}
	
	
	//table[i][j] denote whether a substring from i to j is palindrome.

	public static String longestPalindromeDp(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];

		String longest = null;
		for (int l = 0; l < len; l++) {
			for (int i = 0; i < len - l; i++) {
				int j = i + l;
				System.out.println("l:"+l+" i:"+i+" j:"+j+" char[i]:"+s.charAt(i)+ " char[j]:"+s.charAt(j));
				if (s.charAt(i) == s.charAt(j) && (l <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
                   System.out.println("Matched at "+i+","+j);
					if (l + 1 > maxLen) {
						maxLen = l + 1;
						longest = s.substring(i, j + 1);
						
					}
				}
			}
		}

		return longest;
	}
	

	
	
	

}
