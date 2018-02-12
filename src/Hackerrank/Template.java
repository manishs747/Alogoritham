package Hackerrank;

import java.util.Scanner;
/*
 * 
 * sample input 
  2
sam 99912222
tom 11122222
 */
public class Template {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String name = in.next();
            int phone = in.nextInt();
            System.out.println(name+" has phone number "+phone);
		}
		
		  while(in.hasNext()){
	            String s = in.next();
		  }
	}

}
