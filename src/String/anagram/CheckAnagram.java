package String.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/java-anagrams/problem
public class CheckAnagram {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		if(checkAnagram(first.toLowerCase(), second.toLowerCase())){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}*/
		
		String b = "xaxbbbxx";
		String a = "bbxx";
		System.out.println(anagram(b));
	}
	
	
	 static int anagram(String s) {
		 int result = -1;
		 if (s.length()%2 == 1) {
			 return result;
		 }
		 return isAnagramCount(s.substring(0, s.length()/2), s.substring(s.length()/2));
	  }
	 
	 static int  isAnagramCount(String a, String b) {
		 Map<Character, Integer> map = new HashMap<Character,Integer>();
		 for (Character c : a.toCharArray()) {
			 c = Character.toLowerCase(c);
			 if (map.containsKey(c)) {
				 map.put(c, map.get(c)+1);
			 } else {
				 map.put(c, 1);
			 }
		 }

		 for (Character c : b.toCharArray()) {
			 c = Character.toLowerCase(c);
			 if (map.containsKey(c)) {
				 int count = map.get(c);
				 count = count -1;
				 if (count == 0) {
					 map.remove(c);
				 }else {
					 map.put(c, count);
				 }
			 } 
		 }

		 int sum = 0;
		 for (Character key : map.keySet()) {
			 sum += map.get(key);
		 }
		 return sum;
	 }
	 
	 
	 //https://www.hackerrank.com/challenges/java-anagrams/problem
	 /*
	  * 
	  * 
	  */
	 static boolean isAnagram(String a, String b) {
		 Map<Character, Integer> map = new HashMap<Character,Integer>();
		 for (Character c : a.toCharArray()) {
			 c = Character.toLowerCase(c);
			 if (map.containsKey(c)) {
				 map.put(c, map.get(c)+1);
			 } else {
				 map.put(c, 1);
			 }
		 }

		 for (Character c : b.toCharArray()) {
			 c = Character.toLowerCase(c);
			 if (map.containsKey(c)) {
				 int count = map.get(c);
				 count = count -1;
				 if (count == 0) {
					 map.remove(c);
				 }else {
					 map.put(c, count);
				 }
			 } else {
				 return false;
			 }
		 }
		 return map.isEmpty();
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
