package String;

import java.util.*;


/*
 https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 
fcrxzwscanmligyxyvym
jxwtrhvujlmrpdoqbisbwhmgpmeoke
30


 
 
 
 * 
 */
public class MakingAnagram {
	
	public static int NUMBER_LETTER = 26;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeededHash(a, b));
	}
	
	
	private static int numberNeeded(String first, String second) {
		int [] charCount1  = getCharCount(first);
		int [] charCount2  = getCharCount(second);
		return getDelta(charCount1,charCount2);
	}

	private static int getDelta(int[] charCount1, int[] charCount2) {
		// TODO Auto-generated method stub
		int delta = 0;
		for (int i = 0; i < NUMBER_LETTER; i++) {
			delta +=  Math.abs(charCount1[i]-charCount2[i]);
		}
		return delta;
	}


	private static int[] getCharCount(String str) {
        int offset = (int)'a';
    	int [] charCounts = new int[NUMBER_LETTER];
        for(char c : str.toCharArray()) {
        	int code = c - offset;
        	charCounts[code]++;
        }
		return charCounts;
	}


	private static int numberNeededHash(String a, String b) {
		if(a==null || b==null ){
			return -1;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//iterare first string
		for(char c : a.toCharArray()) {
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}

		for(char c : b.toCharArray()) {
			if(map.containsKey(c)){
				map.put(c, map.get(c)-1);
			}else{
				map.put(c, -1);
			}
		}

		int result = 0;
		for ( Integer v : map.values() ) {
			result = result + Math.abs(v);
		}
		return result;
	}

}
