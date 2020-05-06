package hackerrank;


import java.math.BigInteger;
import java.util.Scanner;

public class FundsIndia {
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = 1299709;
		
		for (int i = 0; i < n; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
		
	   
	    	BigInteger sum  = new BigInteger("0");
			//long sum = 0;
			for (int j = l; j <= r; j++) {
				sum = sum.add(new BigInteger(String.valueOf(sum(j))));
			}
		    System.out.println(sum.remainder(new BigInteger(String.valueOf(m))));
		}
	
		
	}


	
	static long fibonacci(int n,long[] mem){
		if(n<=0)
			return 0;
		if(n==1){
			return 1;
		}
	    if(mem[n]==0){
	    	mem[n]=fibonacci(n-1,mem)+fibonacci(n-2,mem);
	    }
		return mem[n];
	}
	
	static long sum(int n) {
		long result = 0;
		long[] mem = new long[n+2];
        for (int i = 1; i <= n; i++) {
        	long sum = 0;

            for (int j = i + 1; j <= n; j++) {
                    sum = sum + fibonacci(j , mem);
            }

            result = result + (sum * fibonacci(i,mem));
        }

        return result;
    }
	
	
	
	
	 

}
