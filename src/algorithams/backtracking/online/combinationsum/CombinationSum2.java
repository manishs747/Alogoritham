package algorithams.backtracking.online.combinationsum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {


    public static void main(String[] args) {

       int [] candidates = {1,1};
       int target = 1;
       System.out.println(combinationSum2(candidates,target));
    }



    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(candidates,target,0,new ArrayList<>(),result);
        return result;
    }

    public static void combinationSum2(int[] candidates, int target, int index , List<Integer> current , List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(index >= candidates.length || target < 0) return;
        current.add(candidates[index]);
        combinationSum2(candidates,target - candidates[index],index+1,current,result);
        current.remove(current.size()-1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        combinationSum2(candidates,target,index+1,current,result);
    }
}
