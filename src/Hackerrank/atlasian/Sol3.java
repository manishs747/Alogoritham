package Hackerrank.atlasian;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 char [] b7={'0','a', 't', 'l', 's', 'i', 'n'};
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();

	        int i=t;
	        StringBuffer sb = new StringBuffer();
	        while (i != 0 && i > 0){
	            int m=i%7;
	            System.out.println("M:"+m);
	            sb.append(b7[m]);
	            i=i/7;
	        }

	        System.out.println(sb.reverse());
	        in.close();

	}
	
	/*
	 *  char [] b7={'0','a', 't', 'l', 's', 'i', 'n'};
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();

	        int i=t;
	        StringBuffer sb = new StringBuffer();
	        while (i != 0 && i > 0){
	            int m=i%7;
	            sb.append(b7[m]);
	            i=i/7;
	        }

	        System.out.println(sb.reverse());
	        in.close();
	        
	        
	        
	 */
	
	
	

}
