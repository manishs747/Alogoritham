package dynamic_programming.leetocde.PalindromePartitioning;


/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioning2 {


    public static void main(String[] args) {
        System.out.println(minCut("aab"));//1
    }


    public static int minCut(String s) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        int[] cutArr = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (charArr[j] == charArr[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cutArr[j - 1] + 1);
                }
            }
            cutArr[i] = min;
        }
        return cutArr[n - 1];
    }
}
