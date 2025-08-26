package dynamic_programming.leetocde;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
 */
public class BestTimeToBuyStock {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
     int maxProfit = 0 , minPrice = prices[0];
        for (int price:prices) {
            minPrice = Math.min(minPrice,price);
            maxProfit = Math.max(maxProfit,price-minPrice);
        }
     return maxProfit;
    }



}
