import java.math.BigInteger;
import java.util.Scanner;


public class UserInput {
	
	
	
	
	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int a;
	        System.out.println("Please enter First Number:");
	        a = in.nextInt();
	        int b;
	        System.out.println("Please enter Second Number:");
	        b = in.nextInt();
	        int sum;
	        sum = solveMeFirst(a, b);
	        System.out.println("SUM OF "+ a + " + "+ b +" is :");
	        System.out.println(sum);
	}
	
	private static int bigInt(int n){
		BigInteger f = new BigInteger("1");
		//BigInteger val = new BigInteger(n);
		//f.add(val );
		
		return 0;
	}

	private static int solveMeFirst(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
