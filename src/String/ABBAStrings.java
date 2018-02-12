package String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/contests/swiggy-29062017/challenges/abbastrings/problem
//http://oncecoder.blogspot.in/2015/08/abba-srm-663-div-2-500.html
/*
 * Add the letter A to the end of the string.
   Add the letter B to the end of the string and then reverse the entire string. 
   (After the reversal the newly-added B becomes the first character of the string).
 * 
 * 
A
BABA
Possible

A
ABBA
Impossible

AAABBAABB
BAABAAABAABAABBBAAAAAABBAABBBBBBBABB
Possible

BABABBABBBBBBABA
BBBBBBABABBABBBABABBBBBBABBABABBBBBBBABAABBBAAAAAB
Possible

BAAAAABBBBABBABBBAABABAAABAABABABAABAB
BABBBAABABAABABABAABAAABABAABBBABBABBBBAAAAABBBBAA
Possible

BBBABAABAAABAAAAAABBAABAAAAABBABBBBBA
BABBAABBBABAABAAABAAAAAABBAABAAAAABBABBBBBABBAABAA
Possible


 * 
 */
public class ABBAStrings {
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String initial = s.next();
		String target = s.next();
		
		/*if (checkPossible(initial, target)) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}*/
		
		
		Set<String> set   = new HashSet<String>();
		if (valid(initial, target, set)) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
		System.out.println(set);
	}
	
	
	// Reasoning : Instead of going from initial -> target, go the other way
	// around.
	// Why? Target Len > Initial Len and the rules only ever add a
	// character, never remove one.
	// So every time simply do the inverse of the two rules (instead of
	// adding 'A' to the end, remove 'A' from end)
	// After doing the reverse of the rule, recurse again to see if it
	// possible to reach initial.
	// Make sure to Set with already visited strings to make sure we quickly
	// short circuit the recursion
	// and don't keep going down paths we've already discovered!
	public static boolean valid(String initial, String target, Set<String> visited) {
		if(initial.equals(target))
			return true;
		int targetLen = target.length();
		if (initial.length() == targetLen || targetLen == 0) return false;
		if (visited.contains(target)) return false;
		visited.add(target);
		if (target.charAt(targetLen - 1) == 'A' && valid(initial, target.substring(0, targetLen - 1), visited)) {
			return true;
		} else if (target.charAt(0) == 'B' && valid(initial, new StringBuilder(target.substring(1)).reverse().toString(), visited)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//fails for few cases
	 public static boolean checkPossible(String source , String target){
			if(source.equals(target)){
				return true;
			}
			String newWord = source+"A";
			boolean flag  = false;
			if(target.contains(newWord)){
				flag = checkPossible(newWord, target);
			}
			if(flag == true){
				return flag ;
			}
			StringBuilder input = new StringBuilder(source+"B");
			input = input.reverse();
			if(target.contains(input.toString())|| target.contains(source+"B")){
				flag = checkPossible(input.toString(), target);
				
			}else{
				flag = false;
			}
			return flag;
		}

}
