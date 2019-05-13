package String;


//https://www.hackerrank.com/challenges/camelcase/problem
public class HackerString {
	
	static String numbers = "0123456789";
	static String lower_case = "abcdefghijklmnopqrstuvwxyz";
	static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String special_characters = "!@#$%^&*()-+";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	 // Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		int minNum = 4;
		boolean number = false , lc = false , uc = false , sc = false;
		for(char ch : password.toCharArray()) {
			if (!number && numbers.indexOf(ch) != -1) {
				number = true;
				minNum--;
			}
			if (!lc && lower_case.indexOf(ch) != -1) {
				lc = true;
				minNum--;
			}
			if (!uc && upper_case.indexOf(ch) != -1) {
				uc = true;
				minNum--;
			}
			if (!sc && special_characters.indexOf(ch) != -1) {
				sc = true;
				minNum--;
			}
		}
		return Math.max(6-n, minNum);
	}
    
	
	
	
	/*  
	 * 
	Sample Input
	saveChangesInTheEditor
	Sample Output
	5
	*/
	
	 static int camelcase(String s) {
		 int count = 0;
		 for(char ch : s.toCharArray()) {
			 if (isUpperCase(ch)) {
				 count++;
			 }  
		 }
		return count+1;
	 }
	 
	 static boolean isUpperCase(char ch) {
		    return ch >= 'A' && ch <= 'Z';
		}


}
