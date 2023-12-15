package dynamic_programming.struckty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingChange {
    public static void main(String[] args) {
        System.out.println(countingChange(4, List.of(1,2,3)));//4
    }

    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount,0,coins,new HashMap<>());
    }

    public static int countingChange(int amount, int index, List<Integer> coins, Map<String,Integer> memo) {
        if (amount == 0) return 1;
        if (index >= coins.size()) return 0;
        String key = amount+"_"+index;
        if(memo.containsKey(key)) return memo.get(key);
        int amountWithCoin = 0;
        int totalWays = 0;
        while (amountWithCoin <= amount) {
            int remainingAmount = amount - amountWithCoin;
            totalWays += countingChange(remainingAmount, index + 1, coins,memo);
            amountWithCoin += coins.get(index);
        }
        memo.put(key,totalWays);
        return totalWays;
    }
}
