package String;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s = "We promptly judged antique ivory buckles for the next prize";
		String ns = "We promptly judged antique ivory buckles for the prize";
		System.out.println(pangrams(ns));
	}
	
	
	
	static String pangrams(String s) {
		String result = "not pangram";
		Set<Character> set = new HashSet<>();
		for (Character c : s.toCharArray()) {
			set.add(Character.toLowerCase(c));
		} 
		for (Character ch = 'a'; ch <= 'z'; ch++) {
			if (!set.contains(ch)) {
				return result;
			}
		}
		result = "pangram";
		return result;
	}
	  

}
