package dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * https://www.hackerrank.com/challenges/coin-change/problem
 * 
 * https://www.youtube.com/watch?v=sn0DWI-JdNA
 * 
 * https://www.youtube.com/watch?v=rdI94aW6IWw
 * 
 * url : https://www.hackerrank.com/challenges/coin-change
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
		   Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        long[] c = new long[m];
	        for(int c_i=0; c_i < m; c_i++){
	            c[c_i] = in.nextLong();
	        }
	        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
	        long ways = makeChange( c ,n);
	        System.out.println(ways);
	}

	private static long makeChange(long [] coins, int money) {
		return makeChange(coins, money,0,new HashMap<String,Long>());
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
	
	
	
	
	
	
	
	
	
	

}
