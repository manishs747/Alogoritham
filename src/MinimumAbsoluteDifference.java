import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * 
 * 
 * 3
   3 -7 0
   output
   3
 */
public class MinimumAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-59, -36 ,-13, 1, -53, -92 ,-2 ,-96, -54, 75};
		System.out.println(minimumAbsoluteDifference(arr));
	}
	
	
	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			minDiff = Math.min(minDiff,Math.abs( arr[i]-arr[i-1]));
		}
		return minDiff;
	}

}
