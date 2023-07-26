package dynamic_programming.leetocde.sumCombination.unbounded;


import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 *  a list of all unique combinations of candidates
 */
public class CombinationSum {

    public static void main(String[] args) {
       int [] candidates = {2,3,6,7};
       int target = 7;
        System.out.println(combinationSum(candidates,target));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      return combinationSum(candidates,target,0,new HashMap<>());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target,int index, Map<String,List<List<Integer>>> memo) {
       if(target == 0) {
           {
               List<List<Integer>>  emptyList = new ArrayList<>();
               emptyList.add(new ArrayList<>());
               return emptyList;
           }
       }
       if(index >= candidates.length) return new ArrayList<>();
      // String key = target+"_"+index;
      // if(memo.containsKey(key)) return memo.get(key);
       int amountWithCandidates = 0;
       List<List<Integer>> resultantWays = new ArrayList<>();
       while(amountWithCandidates <= target){
           int reminderTarget = target - amountWithCandidates;
           List<List<Integer>> reminderWays = combinationSum(candidates, reminderTarget, index + 1, memo);
           if(!reminderWays.isEmpty()){
               for (List<Integer> reminderWay : reminderWays) {
                   List<Integer> newList = new ArrayList<>(Arrays.asList(candidates[index]));
                   for(int num = 0;num <amountWithCandidates/candidates[index];num++ )
                       newList.add(candidates[index]);
                   newList.addAll(reminderWay);
                   resultantWays.add(newList);
               }
           }
           amountWithCandidates += candidates[index];
        }
      // memo.put(key,resultantWays);
      return resultantWays;
    }
}
