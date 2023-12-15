package dynamic_programming.struckty;

import java.util.Arrays;
import java.util.List;

public class MinChange {

    public static void main(String[] args) {
        System.out.println(minChange(8, List.of(1, 5, 4, 12)));//2
    }

    public static int minChange(int amount, List<Integer> coins) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo,-2);
        return minChange(amount,coins,memo);
    }

    public static int minChange(int amount, List<Integer> coins,int [] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if(memo[amount] != 0) return memo[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin:coins) {
            int subChangeCount = minChange(amount - coin,coins,memo);
            if( subChangeCount != -1){
                minCount = Math.min(minCount,subChangeCount);
            }
        }
        return memo[amount] = minCount != Integer.MAX_VALUE ? minCount+1:-1;
    }

/*****************************************************************************************************/
    public int coinChange(int[] coins, int amount) {
        return coinChange(amount,coins,new int[amount + 1]);
    }

    public int coinChange(int amount,int[] coins,int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if(memo[amount] != 0) return memo[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin:coins) {
            int subChangeCount = coinChange(amount - coin,coins,memo);
            if( subChangeCount != -1){
                minCount = Math.min(minCount,subChangeCount);
            }
        }
        return memo[amount] = minCount != Integer.MAX_VALUE ? minCount+1:-1;
    }

}
