package dynamic_programming.leetocde;


/**
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * <p>
 * https://www.youtube.com/watch?v=IRwVmTmN6go&t=1s
 * https://www.educative.io/courses/dynamic-programming-in-python/xoG0Lmq84yn
 */
public class RodCuttingMaxVal {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + cutRodBottomUp(arr, 8));   //8 --22
    }


    static int cutRodTopDown(int price[], int n) {
        return cutRod(price, n, new int[n + 1]);
    }

    static int cutRod(int price[], int n, int[] memo) {
        if (n <= 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, price[i] + cutRod(price, n - i - 1, memo));
        }
        return memo[n] = maxProfit;
    }


    static int cutRodBottomUp(int price[], int n) {
        int [] memo = new int[n+1];
        for (int i = 1;i < n+1;i++){
           int max_val = 0;
           for(int j = 0 ; j < i;j++){
               max_val = Math.max(max_val,price[j] + memo[i-j-1]);
           }
            memo[i] = max_val;
        }
        return memo[n];
    }


}
