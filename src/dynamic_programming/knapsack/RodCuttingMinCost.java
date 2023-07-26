package dynamic_programming.knapsack;

import java.util.HashMap;
import java.util.Map;

public class RodCuttingMinCost {

    public static void main(String[] args) {
        int n = 7;
        int [] cuts = {1,3,4,5};//16
        System.out.println(minCost(n ,cuts));
    }

    public static int minCost(int n, int[] cuts) {
        return minCostHelper(cuts,0,n,new HashMap<>());
    }

    public static int minCostHelper(int[] cuts, int start, int end, Map<String,Integer> memo) {
        if (start >= end ) return 0;
        String key = start+"_"+end;
        if (memo.containsKey(key)) return memo.get(key);
        int minCost = Integer.MAX_VALUE;
        for (int cut : cuts){
            if(cut > start && cut < end){
                int localMinCost = end - start + minCostHelper(cuts, start, cut,memo) + minCostHelper(cuts, cut, end,memo);
                if( minCost > localMinCost) minCost = localMinCost;
            }
        }
        memo.put(key,minCost ==Integer.MAX_VALUE ? 0 : minCost);
        return  memo.get(key);
    }
}
