package data_structure.strings;

public class CheckIfPallendromeByRemovingChar {
	
	
	
	public static void main(String[] args) {
		String word = "abc";
       System.out.println(convertPalindrome(word));
	}
	
	
	
	 // function to calculate minimum
    // number of deletions
	//https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
	public static int minimumNumberOfDeletions(String str){
	
		
		
		return 0;
	}
	
	
	//add character to make palendrom
	public static String convertPalindrome(String str) {
		// TODO Auto-generated method stub
		if (str == null)
			return str;
		int n = str.length();
		if ((n == 0) || (n == 1))
			return str;
		StringBuilder strBuilder = new StringBuilder(str);
		int low = 0;
		int high = n-1;
		while(low < high){
			System.out.println("Low:"+str.charAt(low) +"  highCar:"+str.charAt(high));
			if(str.charAt(low) == str.charAt(high)){
				low++;
				high--;
			}else{
				strBuilder.insert(high+1, str.charAt(low));
				low++;
			}
			
		}
		return strBuilder.toString();
	}
	
	
	
	// This method returns -1 if it is not possible to make string
	// a palindrome. It returns -2 if string is already a palindrome.
	// Otherwise it returns index of character whose removal can
	// make the whole string palindrome.
	
	static int possiblePalinByRemovingOneChar(String str){
		int low = 0;
		int high = str.length()-1;
		while(low < high){
			if(str.charAt(low) == str.charAt(high)){
				low++;
				high--;
			}else{ //there is a mismatch
				String lowStr = getStringAfterDeletingChar(str, low);
				if(isPallendrome(lowStr)){
					return low;
				}
				String highStr = getStringAfterDeletingChar(str, high);
				if(isPallendrome(highStr)){
					return high;
				}
				return -1;
			}
		
		}	
		return -2;
	}

	private static String getStringAfterDeletingChar(String str, int low) {
		StringBuilder sb = new StringBuilder(str);
		sb.deleteCharAt(low);
		String lowStr = sb.toString();
		return lowStr;
	}

	private static boolean isPallendrome(String str) {
		int low = 0;
		int high = str.length()-1;
		while (low < high)
	    {
	       if (str.charAt(low) != str.charAt(high))
	          return false;
	       low++;
	       high--;
	    }
	    return true;
	}

}
