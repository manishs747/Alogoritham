package data_structure.strings;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-anagrams/problem
public class CheckAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		if(checkAnagram(first.toLowerCase(), second.toLowerCase())){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
	
	public static boolean checkAnagram(String first, String second) {
		return getSortedStr(first).equals(getSortedStr(second));
	}

	public static String getSortedStr(String word) {
		char[] c = word.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
