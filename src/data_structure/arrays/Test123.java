package data_structure.arrays;

import java.util.ArrayList;
import java.util.List;

public class Test123 {

	public static void main(String[] args) {

		
		System.out.println("Hello manish");

		System.out.println(selfDividingNumbers(1,22));

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for(int i=left;i<=right;i++){
			if(isDivisible(i)){
				result.add(i);
			}
		}
		return result;
	}


	public static boolean isDivisible(int num) {
		while (num != 0) {
			int rem = num % 10;
			System.out.println("Num:"+rem);
			if (rem == 0 || num % rem != 0) {
				return false;
			}
			num = num/10;
		}
		return true;
	}

}
