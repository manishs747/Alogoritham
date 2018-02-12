package Hackerrank;

import java.util.Arrays;
import java.util.Collections;

/*
 * 10
hhpddlnnsjfoyxpci
xulkowreuowzxgnhmiqekxhz
dnqaurlp
aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqra
lbafwuoawkxydlfcbjjtxpzpchzrvbtiev
drngbjuuhmwqwxrinxccsqxkp
ubu
vxxzsqjqsnibgydzlyynqcrayvw
xtnipeqhxvafqaggqoanvwk
gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvz
10
ioigvjqzfbpllssuj
istdocbnyozmnqthhpievvlj
lofnrtmh
sqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb
qbpedlqbktorypcjkzzkodrpvosqzxmpad
wygwcdbtriwaesjsobrntzaqbe
lzt
jurfsqfrivayopgrxewwruvemzy
mthtfirwhmjrbphlmeluvoa
nspiwquxxsiwuldizqkkaawpyyisnftdzklwagv

 */

/*
 * 
 * 
 * 10
 * 13
 * 5
 * 26
 * 15
 * -1
 * 3
 * 13
 * 13
 * -1
 */


/*
1
aa
1
ba                 result 1
 */
public class ZaprAnagram {
	
	public static void main(String[] args) {
		
		String a [] = {"a","jk","abb","mn","abc"};
		String b [] = {"bb","kj","bbc","op","def"};
		
		String c [] = {"aa"};
		String d [] = {"ab"};
	
		
		
		getMinimumDifference(c, d);
		
		
	}


	/**
	 * @param testString
	 * @param c
	 * @return
	 */
	private static int getCount(String testString, String c) {
		return testString.length() - testString.replaceAll(c, "").length();
	}


	/**
	 * @param t
	 * @return
	 */

	
	
	static int[] getMinimumDifference(String[] a, String[] b) {
		int result [] =  new int [a.length];
		for (int i = 0; i < result.length; i++) {
			String aw = a[i];
			String bw = b[i];
			int res = processword(aw, bw);
			System.out.println("RESULT FOR word :"+aw+" and "+ bw +" is = "+res);
			result[i]= res;
		}

		return result;
		
    }
	
	static int processword(String a, String b) {
		if(a.length()!=b.length()){
			return -1;
		}
		int anagram = 0;
		for (int i = 0; i < a.length(); i++) {
			//System.out.println("INDEX: "+b.indexOf(a.charAt(i)));
			if((b.indexOf(a.charAt(i)) == -1)){
				anagram = anagram + 1;
			}
		}
		return anagram;

	}
 
}
