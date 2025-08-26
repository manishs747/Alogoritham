package dynamic_programming.leetocde.stock;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock1 {


    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfitNew(prices));
    }

    public static int maxProfitNew(int[] prices) {
      int maxProfit = 0,  min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return maxProfit;
    }










    

    public static int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    }


    public int maxProfit2(int[] prices) {
        int profit = 0,min = Integer.MAX_VALUE;
        for (int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i-min);
        }
        return profit;
    }
}
