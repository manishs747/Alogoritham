package utils;

import java.util.ArrayList;
import java.util.List;

public class NuberUtils {
	
	public static List<Integer> getNumberDigit(int n){
		
		List<Integer> digitlist = new ArrayList<Integer>();
		while(n!=0){
			digitlist.add(0, n%10);
			n=n/10;
		}
		return digitlist;
	}

	public static int reverseNumber(int num){
		int rev = 0 ;
		while(num !=0){
			rev = rev *10 + num%10;
			num = num /10;
		}
		return rev;
	}
	
	public static void main(String[] args) {
		List<Integer> ints = getNumberDigit(1);
		System.out.println(ints);
		
		
		//System.out.println(reverseNumber(258))
	}
}
