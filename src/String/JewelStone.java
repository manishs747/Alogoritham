package String;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * https://www.youtube.com/watch?v=RVghp_caLec&list=PLVFrD1dmDdvd_rChH0L1jeMVZpJ8ZIivE&index=22&t=0s
 * https://leetcode.com/problems/jewels-and-stones/
 * 
 * 
 */
public class JewelStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Input: J = "aA", S = "aAAbbbb"
       Output: 3
       
       Input: J = "z", S = "ZZ"
       Output: 0
	 */
	public int numJewelsInStones(String J, String S) {
		int count = 0;
		Set<Character> jewel = new HashSet<Character>();
		for (Character c : J.toCharArray()) {
			jewel.add(c);
		}
		for (Character c : S.toCharArray()) {
			if(jewel.contains(c)) {
				count++;
			}
		}
		return count;
	}

}
