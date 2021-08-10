package dynamic_programming.leetocde.sellstock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class SellStockWithCooldown {

    public static void main(String[] args) {
       int arr [] = {7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int prev = prices[0];
        for (int i =1;i < prices.length;i++){
           if(prices[i] >  prev){
               profit += prices[i] -prev;
           }
            prev = prices[i];
        }
        return profit;
    }
}
