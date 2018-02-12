package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter Number to Reverse");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.println("You Have Entered "+ number);
		int rev = normalReverse(number);
		System.out.println("Reverse of "+ number+" is "+rev);
		
		
		
		//System.out.println("Reverse is "+);

	}
	
	
	
	
	
	public static int normalReverse(int num ){
		int rev = 0;
		while(num != 0){
			rev = rev*10 + num % 10;
			num = num / 10;
		}
		return rev;
	}
	
	public static int reverse(int num){
		Stack<Integer> numStack = new Stack();
		while(num != 0){
		int rem = num % 10;
		System.out.println("rem"+rem);
		num = num/10;
		numStack.push(rem);
		}
		return num;
		
	}

}
