package Hackerrank.atlasian;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String start = in.next();
		int repeat =  in.nextInt();
		String result = lookandsay(start);
		
		for(int i = 1;i < repeat;i++) {
			result  = lookandsay(result);
		}
		System.out.println(result);

	}
	
	
	public static String lookandsay(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}

}
