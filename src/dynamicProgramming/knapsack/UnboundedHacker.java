package dynamicProgramming.knapsack;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/unbounded-knapsack/problem
public class UnboundedHacker {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
       for(int j = 0;j < t;j++) {
    	   
       
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = unboundedKnapsack(k, arr);
        System.out.println(result);
       }
       
        scanner.close();
	}
	
	
	
	static int unboundedKnapsack(int k, int[] arr) {
		Map<String, Integer> memo = new HashMap<>();
		return k-unboundedKnapsack(k, arr,0, memo);
    }
	
	
	static int unboundedKnapsack(int k, int[] arr,int index,Map<String,Integer> memo) {
		if(k == 0) {
			return 0;
		}
		if(index >= arr.length) {
			return k;
		}
		String key = k +"_"+index;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int min = Integer.MAX_VALUE;
		int amountWithK = 0;
		while(amountWithK <= k) {
			int val = unboundedKnapsack(k-amountWithK, arr, index+1, memo);
			min = Math.min(min, val);
			amountWithK += arr[index];
		}
		memo.put(key, min);
		return min;
	}

}
