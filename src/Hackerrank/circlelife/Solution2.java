package Hackerrank.circlelife;

import java.math.BigInteger;
import java.util.Scanner;


//https://stackoverflow.com/questions/54812971/programming-minimum-steps-required-to-convert-a-binary-number-to-zero

public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int number = in.nextInt();
		
		}

	}
	
	//working and submitted
	static long calculateStepsRequired(long n) {
	    // Take sign bit
	    int bit = n < 0 ? 1 : 0;
	    BigInteger result = BigInteger.valueOf(bit);
	    for (int i = 0; i < 63; i++) {
	        n = n << 1;
	        int sign = n < 0 ? 1 : 0;
	        bit = (bit + sign) % 2;
	        result = result.shiftLeft(1).add(BigInteger.valueOf(bit));
	    }
	    return result.longValue();
	}
	

	
	
	

}
