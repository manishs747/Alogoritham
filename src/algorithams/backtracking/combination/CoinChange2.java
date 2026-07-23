package algorithams.backtracking.combination;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class CoinChange2 {


    public static void main(String[] args) {
        int amount = 4;
        int []coins = {1,2};
        //Output: 4
        System.out.println(change(amount,coins));
    }


    /************************************************ DIFF WAY OF TOP DOWN Approch*****************************************************************/
    public static int change(int amount, int[] coins) {
      return change(amount,coins,0,new HashMap<String,Integer>());
    }

    public static int change(int amount, int[] coins,int index,Map<String,Integer> memo) {
        if(amount == 0) return 1;
        if (index == coins.length) return 0;
        String key = amount + "_"+ index;
        if (memo.containsKey(key)) return memo.get(key);
        int ways = 0;
        int amountWithCoins = 0;
        while(amountWithCoins<= amount){
            ways += change(amount-amountWithCoins,coins,index+1,memo);
            amountWithCoins += coins[index];
        }
        memo.put(key,ways);
        return ways;
    }



    /************************************************ Top DOWN USING MAP*****************************************************************/
    public static int change1(int amount, int[] coins) {
        return change1(amount, coins, 0, new HashMap<>());
    }

    public static int change1(int amount, int[] coins, int  index , Map<String,Integer> memo) {
         if(index == coins.length || amount < 0) return 0;
         if(amount == 0) return 1;
         String key = amount + "_" + index ;
         if(memo.containsKey(key)) {return memo.get(key);}
         int waysWithoutCur = change1(amount, coins, index + 1, memo);
         int waysWithCur = change1(amount-coins[index], coins, index, memo);
         int ans = waysWithoutCur + waysWithCur;
         memo.put(key,ans);
         return ans;
    }

    /***********************************************Top DOWN USING ARRAY******************************************************************/


    public static int change2(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount+1][coins.length];
        return change2(amount, coins, 0, memo);
    }

    public static int change2(int amount, int[] coins, int  index , Integer[][] memo) {
        if(amount == 0) return 1;
        if(index == coins.length || amount < 0) return 0;
        if(memo[amount][index] != null) {return memo[amount][index];}
        int waysWithoutCur = change2(amount, coins, index + 1, memo);
        int waysWithCur = change2(amount-coins[index], coins, index, memo);
        return memo[amount][index] = waysWithoutCur + waysWithCur;
    }

    /***********************************************Bottom  UP USING ARRAY******************************************************************/

}
