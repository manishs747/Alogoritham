package dynamic_programming.leetocde.sumCombination.unbounded;

import java.util.HashMap;
import java.util.Map;

public class MakeChange {

    public static void main(String[] args) {
        int target = 27;
        int coins [] = {25,10,5,1};
        System.out.println(makeChange(coins,27));
    }

    public static long makeChange(int [] coins ,int money){
        return makeChange(coins,money,0,new HashMap<String,Long>());
    }

    public static long makeChange(int [] coins ,int money,int index, Map<String,Long> memo){
        if (money == 0) return 1;
        if(index >= coins.length) return 0;
        String key = money+"_"+index;
        if(memo.containsKey(key)) return memo.get(key);
        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money){
            int reminderMoney = money - amountWithCoin;
            ways += makeChange(coins,reminderMoney,index+1,memo);
            amountWithCoin += coins[index];
        }
        memo.put(key,ways);
        return ways;
    }



}
