package recurssion;

import java.math.BigInteger;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/extra-long-factorials
public class Factorial {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println("Factorial of "+num+" is "+factorial(num));
		
	}
	
	public static BigInteger factorial(int num) {
		if (num == 1) {
			return BigInteger(String.valueOf(num));
		}
		// Initialize result
      //  BigInteger f = new BigInteger(num);
		return num * factorial(num - 1);

	}

}
