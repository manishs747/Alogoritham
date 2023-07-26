package dynamic_programming.leetocde;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubsequence {

    public static void main(String[] args) {
       int [] arr = {3,0,-3,4,-4,7,6};
       int difference = 3; //2
        System.out.println(longestSubsequence(arr,difference));
    }

    public static int  longestSubsequence(int[] arr, int difference) {
        int maxResult = Integer.MIN_VALUE;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentResult = 1 + memo.getOrDefault(arr[i]+difference, 0);
            maxResult = Math.max(maxResult, currentResult);
            memo.put(arr[i], currentResult);
        }
        return maxResult;
    }

    public static int  longestSubsequence2(int[] arr, int difference) {
        int maxResult = Integer.MIN_VALUE;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int currentResult = 1 + memo.getOrDefault(arr[i]- difference, 0);
            maxResult = Math.max(maxResult, currentResult);
            memo.put(arr[i], currentResult);
        }
        return maxResult;
    }



}
