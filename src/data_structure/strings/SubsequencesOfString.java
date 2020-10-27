package data_structure.strings;


/*
 * 
https://www.geeksforgeeks.org/print-subsequences-string/

Input : abc
Output : a, b, c, ab, bc, ac, abc

Input : aaa
Output : a, aa, aaa

 * 
 * 
 */

public class SubsequencesOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = "aaa";
	     SubString(str, str.length());

	}
	
	
	
	   public static void SubString(String str, int n)
	    {
	       for (int i = 0; i < n; i++) 
	           for (int j = i+1; j <= n; j++)
	            
	                // Please refer below article for details
	                // of substr in Java
	                // https://www.geeksforgeeks.org/java-lang-string-substring-java/
	                System.out.println(str.substring(i, j));
	    }
	   

}
