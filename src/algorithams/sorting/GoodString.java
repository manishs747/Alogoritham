package algorithams.sorting;

import java.util.Scanner;



public class GoodString {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		System.out.println(getLuckyCount(A, B));
	}
	
	
	public static long getLuckyCount(int A,int B){
		long count = 0;
		for (int i = A; i <= B; i++) {
			if(isLuck(i)){
				count++;
			}
		}
		return count;
	}
	
	public static boolean isLuck(long number){
		boolean result = false ;
	   
	    while(number > 0) {
	       long tmp = number % 10;
	       number /= 10;
	       System.out.println("tmp"+tmp);
	        if(tmp == 4 || tmp == 7){
	        	result = true;
	        }else{
	        	result = false;
	        	break;
	        }
	    }
	    return result;
	}

}
