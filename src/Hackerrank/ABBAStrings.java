package Hackerrank;

import java.util.Scanner;

public class ABBAStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		String source = in.next();
		String target = in.next();
		boolean flag = checkPossible(source, target);//"BABA"
		String result = (flag) ? "Possible": "Impossible";
		System.out.println(result);
	}
	
	
	public static boolean checkPossible(String source, String target) {
		if (source.equals(target)) {
			return true;
		}
		if(source.length() > target.length() ){
			return false;
		}
		String newWord = source + "A";
		boolean flag = false;
		if (target.contains(newWord)) {
			flag = checkPossible(newWord, target);
		}
		if (flag == true) {
			return flag;
		}
		StringBuilder input = new StringBuilder(source + "B");
		input = input.reverse();
		if (target.contains(input.toString()) || target.contains(source + "B")) {
			flag = checkPossible(input.toString(), target);

		} else {
			System.out.println("Check1 = "+input.toString());
			flag = false;
		}
		System.out.println("Check2 = "+input.toString());
		return flag;
	}

}
