package dynamic_programming;


/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LargestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = {0,1,0,3,2,3};//4
        System.out.println(lengthOfLIS(arr));//4
    }


    public static int lengthOfLIS(int[] nums) {
       return lengthOfLIS(nums,0,-1);
    }

    public static int lengthOfLIS(int[] nums,int index,int max) {
        if(index == nums.length-1){
            return 1;
        }
        //int count = Math.max(1+lengthOfLIS(nums,index+1,));

        return 0;
    }

    public static String longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: all substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Iterate over all possible substring lengths and positions
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        // Reconstruct the longest palindromic subsequence
        StringBuilder sb = new StringBuilder();
        int i = 0, j = n - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.charAt(i));
                i++;
                j--;
            } else if (dp[i+1][j] >= dp[i][j-1]) {
                i++;
            } else {
                j--;
            }
        }

        return sb.toString();
    }



}
