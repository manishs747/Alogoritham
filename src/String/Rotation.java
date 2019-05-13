package String;

import java.util.Scanner;

public class Rotation {

	
	
	//https://www.hackerrank.com/contests/codemania/challenges/string-rotation
	public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);
	int count = in.nextInt();
	for (int i = 0; i <count; i++) {
			String str1 = in.next();
			String str2 = in.next();
			String result = areRotations(str1, str2) ? "YES" : "NO"; 
			System.out.println(result);
		}
	}



static boolean areRotations(String str1, String str2) 
{  
    return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1); 
} 


}
