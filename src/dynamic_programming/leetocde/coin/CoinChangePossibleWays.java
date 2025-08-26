package dynamic_programming.leetocde.coin;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=sn0DWI-JdNA
 * https://www.hackerrank.com/challenges/coin-change/problem
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 */
public class CoinChangePossibleWays {

    public static void main(String[] args) {
        Long[] ca = {1L,2L,3L};
        int [] can = {2,5,3,6};
        List<Long> list = Arrays.asList(ca);
        System.out.println(getWays(4,list));
        //System.out.println(coinChangeBottomUp(can,10));
    }

    /******************************************TOP DOWN NEW************************************************************************/

    public static long getWays(int n, List<Long> c) {
        return makeChangeNew(c,n,0,new HashMap<>());
    }

    public static long makeChangeNew( List<Long> coins, long money,int index, Map<String,Long> memo){
      if (money == 0) return 1;
      if(index >= coins.size()) return 0;
      String key = money+"_"+index;
      if(memo.containsKey(key)) return memo.get(key);
      long numberofWays = 0 ;
      while (money >= 0){
          numberofWays += makeChangeNew(coins,money,index+1,memo);
          money -= coins.get(index);
      }
      memo.put(key,numberofWays);
      return numberofWays;
    }


    /******************************************TOP DOWN************************************************************************/

    /**
     * Time(a*c) amount* number of coin
     * Space(a*c)
     */

    public static long makeChange( List<Long> coins, long money,int index, Map<String,Long> memo){
        if (money == 0) return 1;
        if(index >= coins.size()) return  0;
        String key = money+"_"+index;
        if(memo.containsKey(key)) return memo.get(key);
        long amountWithCoin = 0;
        long ways = 0;
        while(amountWithCoin <= money){
            long remainingMoney = money - amountWithCoin;
            ways += makeChange(coins, remainingMoney,index+1,memo);
            amountWithCoin += coins.get(index);
        }
        memo.put(key,ways);
        return ways;
    }


    // this should not work as diff order is same
    public static long getWaysHelper(long money, List<Long> coins, int index, Map<String,Long> memo){
        if (money ==0){
            return 1;
        }
        if(money < 0 || index >= coins.size()){
            return  0;
        }
        String key = index+"_"+money;
        if(!memo.containsKey(key)){
            memo.put(key,getWaysHelper(money,coins,index+1,memo) + getWaysHelper(money-coins.get(index),coins,index,memo));
        }
        return  memo.get(key);
    }


    /******************************************BOTTOM UP************************************************************************/

    public static int coinChangeBottomUp(int[] coins, int amount) {
        int [] memo = new int[amount+1];
        memo[0] = 1;
        for (int coin:coins) {
            for (int i =coin;i < memo.length;i++){
                    memo[i] += memo[i-coin];
            }
        }
        ArrayUtils.print(memo);
        return  memo[amount];
    }

    /*
        https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
         */
    public static class CoinChangeMinCountUnlimited {

        public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
            //Output: 3
            //Explanation: 11 = 5 + 5 + 1
            System.out.println(coinChange(coins,amount));
        }


        public static int coinChange(int[] coins, int amount) {
            return coinChange(coins, amount,new HashMap<>());
        }

        private static int coinChange(int[] coins, int amount , Map<Integer,Integer> memo) {
            if(amount == 0) return 0;
            if(amount < 0) return -1;
            if(memo.containsKey(amount)) return memo.get(amount);
            int minCount = -1;
            for (int cur : coins) {
                int curCount = coinChange(coins, amount -cur,memo);
                if(curCount > -1 && (minCount == -1 || curCount < minCount)){
                    minCount = curCount +1;
                }
            }
            memo.put(amount,minCount);
            return minCount;
        }
    }
}
