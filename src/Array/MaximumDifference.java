package Array;
//Maximum difference between two elements such that larger element appears after the smaller number


/*
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = 

Output : 2
Explanation : The maximum difference is between 9 and 7.
 */



public class MaximumDifference {

	public static void main(String[] args) {
		int [] arr = {2, 3, 10, 6, 4, 8, 1};
		//int [] arr = {7, 9, 5, 6, 3, 2};
		System.out.println(maxDiff(arr));
		

	}
	
	
	public static int maxDiff(int [] arr) {
		int maxDiff = 0;
	    int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				int diff = arr[j] - min;
				maxDiff = Math.max(maxDiff,diff);
			}
		return maxDiff;
	}
	

	public static int maxDiffN2(int [] arr) {
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int diff = arr[j] - arr[i];
				maxDiff = Math.max(maxDiff,diff);
			}
		}
		return maxDiff;
	}


}
