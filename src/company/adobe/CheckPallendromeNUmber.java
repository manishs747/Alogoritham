package company.adobe;

import java.util.Scanner;

//http://www.geeksforgeeks.org/check-if-a-number-is-palindrome/
/*
 * http://www.geeksforgeeks.org/Adobe-topics-interview-preparation/
 * 1000000003
 * 
 */
public class CheckPallendromeNUmber {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(revNumIterative(num));
	/*	if(isPalindrome(num)){
			System.out.println("Palindrome");
		}else{
			System.out.println("NOT A Palindrome");
		}*/
		System.out.println(Integer.MAX_VALUE);
		//System.out.println(Long.);
	}
	
	public static boolean isPalindrome(int num){
		
		
		
		return false;
		
	}
	
	public static long revNumIterative(int num) {
		long result = 0;
		while (num != 0) {
			int remainder = num % 10;
			num = num / 10;
			if(Integer.MAX_VALUE < (result * 10 + remainder)){
				result = 0;
				break;
			}else{
				result = result * 10 + remainder;
			}
			
		}
		return result;
	}

}
