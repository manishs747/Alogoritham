package algorithams.backtracking.neetcode.combinationsum;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {2};
        int amount = 3;
        //Output: 3
        System.out.println(coinChange(coins,amount));
    }

    /***********************    Top Down Approch        ***********************************************************/


    public static int coinChange2(int[] coins, int amount) {
        int [] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return coinChange2(coins, amount, memo) ;
    }

    public static int coinChange2(int[] coins, int amount, int [] memo) {
     if(amount == 0) return 0;
     if(amount < 0) return -1;
     if(memo[amount] != -2) return memo[amount];
     int ways = Integer.MAX_VALUE;
     for(int coin : coins){
       int reminderWays = coinChange2(coins, amount - coin, memo);
         if (reminderWays >= 0) {
             ways = Math.min(ways, reminderWays + 1);
         }
     }
     return memo[amount] =  ways == Integer.MAX_VALUE ? -1 : ways;
    }


    /***********************    Top Down Approch        ***********************************************************/


    public static int coinChange(int[] coins, int amount) {
        int [] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for(int i = 1 ;i <= amount ; i++){
            for(int coin : coins){
              if(i - coin >= 0 ){
                  memo[i] = Math.min(memo[i], memo[i - coin] + 1);
              }
            }
        }
        return memo[amount]  > amount ? -1 : memo[amount] ;
    }





    /***********************            ***********************************************************/


    public static int coinChange1(int[] coins, int amount) {
        return coinChange1(coins, amount, new HashMap<>()) ;
    }

    public static int coinChange1(int[] coins, int amount ,  HashMap<Integer,Integer> memo) {
          if(amount == 0) return 0;
          if(amount < 0) return -1;
          if(memo.containsKey(amount)) return memo.get(amount);
          int ways = Integer.MAX_VALUE;
          for(int coin : coins){
            int reminderWays = coinChange1(coins, amount - coin, memo);
            if(reminderWays == -1) continue;
            ways = Math.min(ways, reminderWays+1);
          }
          ways  = ways == Integer.MAX_VALUE ? -1 : ways;
          memo.put(amount, ways);
          return  ways;
    }




}
