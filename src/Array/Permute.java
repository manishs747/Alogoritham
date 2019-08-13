package Array;

import java.util.*;

/*
 * https://leetcode.com/problems/permutations/
 * 
 * 
 * Input: [2,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * 
 * 
 */

public class Permute {


	public static void main(String[] args){
		Permute.permute(Arrays.asList(1,2,3), 0);
	}

	static void permute(List<Integer> arr, int k){
		for(int i = k; i < arr.size(); i++){
			Collections.swap(arr, i, k);
			permute(arr, k+1);
			Collections.swap(arr,i,k);
		}
		if (k == arr.size() -1){
			System.out.println(java.util.Arrays.toString(arr.toArray()));
		}
	}
}
