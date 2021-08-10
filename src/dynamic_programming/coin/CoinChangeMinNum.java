package dynamic_programming.coin;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChangeMinNum {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        System.out.println(coinChange(coins,11));//3
    }


    public static int coinChange(int[] coins, int amount) {
        return coinChange(coins,amount,new int [amount+1]);
    }

    public static int coinChange( int[] coins,int money, int [] memo){
        if (money ==0){
            return 0;
        }
        if(money < 0 ){
            return  -1;
        }
        if(memo[money] != 0){
            return memo[money];
        }
        int minCount = money+1;
        for (int coin:coins) {
            int c = coinChange(coins,money-coin,memo);
            if(c != -1){
                minCount = Math.min(minCount,c+1);
            }
        }
        memo[money] = minCount == money+1 ? -1: minCount;;
        return  memo[money];
    }


    /******************************************BOTTOM UP************************************************************************/

    /**
     * Best Solution
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeBottomUp(int[] coins, int amount) {
        int [] memo = new int[amount+1];
        for (int i =1;i < memo.length;i++){
            int minCount = amount+1;
            for (int coin:coins) {
                if(coin <= i){
                    minCount = Math.min(minCount,1+memo[i-coin]);
                }
            }
            memo[i] = minCount;
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }

    public static int coinChangeBottomUp1(int[] coins, int amount) {
        int [] memo = new int[amount+1];
        Arrays.fill(memo, amount+1);
        memo[0] = 0;
        for (int coin:coins) {
            for (int i =coin;i < memo.length;i++){
                memo[i] = Math.min(memo[i],1+memo[i-coin]);
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }

    public int coinChangeBottomUp2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
