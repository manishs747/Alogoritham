package dynamic_programming.leetocde.sumCombination.unbounded;

import java.util.ArrayList;
import java.util.List;

public class HowSumNew {

    public static void main(String[] args) {
        int [] candidates = {2,3,5};
        System.out.println(combinationSum(candidates,10));//5,5
    }



    public static List<Integer> combinationSum(int[] candidates, int target){
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;
        List<Integer> bestSum = null;
        for (int candidate:candidates) {
          int remaining = target - candidate;
          List<Integer> remainingList = combinationSum(candidates, remaining);
          if(remainingList != null){
              remainingList.add(candidate);
              if(bestSum == null || bestSum.size() > remainingList.size()){
                  bestSum = remainingList;
              }
          }
        }
        return bestSum;
    }
}
