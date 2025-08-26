package algorithams.backtracking.online.combinationsum;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * check make change
 */
public class combinationsum {

    public static void main(String[] args) {
       int [] candidates = {2,3,5};
       int target = 8;
       System.out.println(combinationSumBacktrack(candidates,target));
    }


  /****************************************************************************************************************************************/





/**********************************************************************************************************************************************/
    public static List<List<Integer>> combinationSumBacktrack(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
         if(target == 0) {
             result.add(new ArrayList<>(current));
             return;
         }
         if(index >= candidates.length || target <  0) return;
         current.add(candidates[index]);
         backtrack(candidates,target -candidates[index],index,current,result );
         current.remove(current.size()-1);
         backtrack(candidates,target ,index+1,current,result );
    }


/*********************************************************************************************************************************/


    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        return  combinationSum(candidates,target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target,int index) {
          List<List<Integer>> resultList = new ArrayList<>();
          if(target == 0) resultList.add(new ArrayList<>());
          if(index >= candidates.length || target == 0) return resultList;
          int amountWithCoin = 0 , count = 0;
          while (amountWithCoin <= target){
              List<List<Integer>> reminderList = combinationSum(candidates, target - amountWithCoin, index + 1);
              for (List<Integer> list:reminderList) {
                  ArrayList<Integer> newlist = new ArrayList<>(list);
                  for (int i = 0; i < count; i++) {
                      newlist.add(candidates[index]);
                  }
                  resultList.add(newlist);
              }
              amountWithCoin += candidates[index];
              count++;
          }
        return resultList;
    }




    //in this approch differnt order is also considered din solutions (not in current solution)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(target == 0) {
            resultList.add(new ArrayList<>());
            return resultList;
        }
        if(target < 0) return resultList;
        for (int candidate: candidates) {
            List<List<Integer>> reminderList = combinationSum2(candidates, target - candidate);
            for (List<Integer> list: reminderList) {
                ArrayList<Integer> newlist = new ArrayList<>(list);
                newlist.add(candidate);
                resultList.add(newlist);
            }
        }
        return resultList;
    }
}
