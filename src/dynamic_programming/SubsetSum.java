package dynamic_programming;

import java.util.Arrays;

/*
 * 
 * 
 https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * https://www.geeksforgeeks.org/partition-problem-dp-18/?ref=lbp
 *
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
 *
 Partition problem is to determine whether a given set can be partitioned into two subsets such that
 * the sum of elements in both subsets is the same.
 *
	arr[] = {1, 5, 11, 5}
	Output: true
	The array can be partitioned as {1, 5, 5} and {11}

	arr[] = {1, 5, 3}
	Output: false
	The array cannot be partitioned into equal sum sets.
 * 
 */
public class SubsetSum {

	public static void main(String[] args) {
        int[] arr1  = {1, 2, 3, 4};//true
		int[] arr2  = {1, 1, 3, 4, 7};//true
		int[] arr3  = {2, 3, 4, 6};//false

	}


	public boolean canPartition(int[] nums) {
		int sum =  Arrays.stream(nums).sequential().sum();
		if(sum % 2 != 0){
			return false;
		}
		int half = sum/2;
		return false;

		return true;
	}

}
