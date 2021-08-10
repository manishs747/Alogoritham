package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test {


	public static Set<Character> vowels = new HashSet<>(Arrays.asList( 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));



	public static void main(String[] args) {

		halvesAreAlike("mani");
		 

	}


	public static boolean halvesAreAlike(String s) {
		String a = s.substring(0,s.length()/2);
		String b = s.substring(s.length()/2);
		return count(a) == count(b);
	}

	public static int count(String s){
		int count = 0;
		for (char c:s.toCharArray()) {
			if (vowels.contains(c)) {
				count++;
			}
		}
		return count;
	}

}
