package algorithams.backtracking.online.combinationsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeChange {


    public static void main(String[] args) {
        List<Long> c = new ArrayList<>();
        c.add(1L);
        c.add(2L);
        c.add(3L);
        System.out.println(getWays(3,c));

    }


    public static long getWays(int n, List<Long> c) {
        return getWaysBackTrack(n,c,0);
    }

    public static long getWaysBackTrack(long amount, List<Long> coins , int index) {
        if(amount == 0) return 1;
        if(index >= coins.size() || amount < 0 ) return 0;
        long ways = 0;
        ways += getWaysBackTrack(amount - coins.get(index) ,coins, index);
        ways += getWaysBackTrack(amount,coins,index+1);
        return ways;
    }

    public static long getWays(long amount, List<Long> coins , int index, Map<String,Long> memo) {
        if(amount == 0) return 1;
        if(index >= coins.size()) return 0;
        String key = amount+"_"+index;
        if(memo.containsKey(key))  return memo.get(key);
        long ways = 0 ,amoutWithCoin = 0;
        while (amoutWithCoin <= amount){
            ways += getWays(amount - amoutWithCoin,coins,index+1,memo);
            amoutWithCoin += coins.get(index);
        }
         memo.put(key,ways);
         return ways;
    }
}
