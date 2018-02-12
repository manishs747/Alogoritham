import java.math.BigInteger;
import java.util.Scanner;


public class Bigint {
	
	
		public static BigInteger modifiedFib(BigInteger a,BigInteger b,int n){
			if(n==1){return a;}
	        if(n==2){return b;}
			return modifiedFib(a,b,n-1).multiply(modifiedFib(a,b,n-1)).add(modifiedFib(a,b,n-2));
		}
	    public static void main(String[] args) {
	    	BigInteger b1 = new BigInteger("5");
	    	BigInteger b2 = new BigInteger("3");
	    	System.out.println(Long.MAX_VALUE);
	    	System.out.println(Integer.MAX_VALUE);
	    	
	    	BigInteger b3 = b1.add(b2);
	    	System.out.println(b3);
	    	
	     
	    }

}
