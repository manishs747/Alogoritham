package data_structure.arrays;

import java.math.BigInteger;

public class BigInt {

	public static void main(String[] args) {
	
		
		        BigInteger b1 = new BigInteger("987654321987654321000000000");
	
		        BigInteger b2 = new BigInteger("987654321987654321000000000");
		
		        BigInteger product = b1.multiply(b2);
	
		        BigInteger division = b1.divide(b2);
		
		        System.out.println("product = " + product);
	
		        System.out.println("division = " + division);
		        new BigInteger("1234456").compareTo(new BigInteger("23456789"));

	}

}
