package Array.online;

import java.util.List;

public class SherlockAndArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//https://www.hackerrank.com/challenges/sherlock-and-array/problem
	
	/*3
	5
	1 1 4 1 1
	4
	2 0 0 0
	4
	0 0 2 0 
	
	
YES
YES
YES
	
	
	*/
	
	static String balancedSums(List<Integer> arr) {
		if(arr.size() <= 1) {
			return "YES";
		}
		int total = sum(arr);
		int sum = 0;
		for (Integer val : arr) {
			if(sum == (total - val - sum)) {
				return "YES"; 
			} 
			sum += val;
		}
		return "NO";
	}
	  
	  
	public static int sum(List<Integer> arr) {
		int sum = 0;
		for (Integer val : arr) {
			sum += val;
		}
		return sum;
	}

}
