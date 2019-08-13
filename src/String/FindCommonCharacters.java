package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {





	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] A =  {"bellal","labezl","ralerbl"};
		System.out.println(commonChars(A));
		

	}
	
	
	
	/*
	 * https://leetcode.com/problems/find-common-characters/
	 * 
	 * 
	 * Input: ["bella","label","roller"]
Output: ["e","l","l"]

   Input: ["cool","lock","cook"]
Output: ["c","o"]

	 */
	
	public static List<String> commonChars(String[] A) {
		List<String> result = new ArrayList<>();
		int[] count = new int[26]; 
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String word : A) {
			int[] charCount = new int[26]; 
			for (char c : word.toCharArray()) {
				++charCount[c-'a'] ;
			}
			for (int i = 0;  i < 26 ;i++) {
				count[i] =  Math.min(charCount[i],count[i]);
			}
		}
		for (char c = 'a'; c <= 'z'; ++c) {
			while (count[c - 'a']-- > 0) {
				result.add(c+"");
			}
		}
		return result;
	}

}
