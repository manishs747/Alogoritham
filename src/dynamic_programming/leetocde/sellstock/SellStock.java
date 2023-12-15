package dynamic_programming.leetocde.sellstock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class SellStock {


    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};//5
        int[] arr1 = {7, 6, 4, 3, 1};//0
        System.out.println(maxProfit(arr1));
    }

    public static int maxProfit2(int[] prices) {
        int max = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    }


    public int maxProfit3(int[] prices) {
        int profit = 0,min = Integer.MAX_VALUE;
        for (int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i-min);
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for(int i =1;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                profit = Math.max(profit,prices[i] - min);
            }
        }
        return profit;
    }
}
