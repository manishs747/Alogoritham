package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
\

https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/


 * 
 * 
 * 
 */

public class Main {
	
	public static final int price [] = {1, 5, 8, 9, 10, 17, 17, 20};

	public static void main(String[] args) {
	
		
		int [] ar1 = {1, 5, 8, 9, 10, 17, 17, 20};
		
		
	
	}
	
	private static int makeChange(long [] coins, int money) {
		return makeChange(coins, money,0,new HashMap<String,Integer>());
	}

	private static int makeChange(long [] coins,long money ,int index,Map<String,Integer> memo){	
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

		int ways = 0;
		int amountWithCoin = 0;
		while(amountWithCoin <= money){
			long remainingMoney = money - amountWithCoin;
			ways += makeChange(coins, remainingMoney,index+1,memo);
			amountWithCoin +=coins[index];
		}
		memo.put(key, ways);
		return ways;
	}



}