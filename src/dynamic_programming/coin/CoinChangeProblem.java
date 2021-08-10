package dynamic_programming.coin;

import java.util.HashMap;
import java.util.Map;


/*
 * https://www.hackerrank.com/challenges/coin-change/problem
 * 
 * https://www.youtube.com/watch?v=sn0DWI-JdNA
 * 
 * https://www.youtube.com/watch?v=rdI94aW6IWw
 * 
 * url : https://www.hackerrank.com/challenges/coin-change
 * https://leetcode.com/problems/coin-change/
//www.hackerrank.com/challenges/ctci-coin-change/problem
 * 
 * 
 4 3
 1 2 3
 4  
   
10 4
2 5 3 6
5
   
 * 
 * 
 * 
 */
public class CoinChangeProblem {

	public static void main(String[] args) {

	}

	private static long makeChange(long [] coins, int money) {
		return makeChange(coins, money,0,new HashMap<>());
	}
	
	private static long makeChange(long [] coins,long money ,int index,Map<String,Long> memo){	
		if(money == 0){
			return 1;
		 }
		if(index >= coins.length){
			return 0;
		}
		
		String key = money+"_"+index;
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		
		long ways = 0;
		long amountWithCoin = 0;
		while(amountWithCoin <= money){
			long remainingMoney = money - amountWithCoin;
			ways += makeChange(coins, remainingMoney,index+1,memo);
			amountWithCoin +=coins[index];
		}
		memo.put(key, ways);
		return ways;
	}



	/***
	 * https://leetcode.com/problems/coin-change/
	 * You are given coins of different denominations and a total amount of money amount.
	 * Write a function to compute the fewest number of coins that you need to make up that amount.
	 * If that amount of money cannot be made up by any combination of the coins, return -1.
	 * You may assume that you have an infinite number of each kind of coin.
	 * Example 1:
	 * Input: coins = [1,2,5], amount = 11
	 * Output: 3
	 * Explanation: 11 = 5 + 5 + 1

	 */
	public int coinChangeMinCoin(int[] coins, int amount) {
		return coinChangeMinCoin(coins, amount, new int[amount]);
	}

	private int coinChangeMinCoin(int[] coins, int rem, int[] count) {
		if (rem < 0) return -1;
		if (rem == 0) return 0;
		if (count[rem - 1] != 0) return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChangeMinCoin(coins, rem - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}
	
	
	
	
	
	

}
