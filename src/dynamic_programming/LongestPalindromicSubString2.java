package dynamic_programming;

public class LongestPalindromicSubString2 {

    public static void main(String[] args) {

    }

    public static String longestPalindromicSubstring(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // Base cases
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // Iterate over all possible substring lengths and positions
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (k > maxLen) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }


    static  boolean ispal(String str){
        return str.equals(new StringBuilder(str).reverse().toString())  ? true : false;
    }
}
