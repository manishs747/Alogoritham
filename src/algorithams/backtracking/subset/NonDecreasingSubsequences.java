package algorithams.backtracking.subset;


import utils.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/non-decreasing-subsequences/description/
 */
public class NonDecreasingSubsequences {

    public static void main(String[] args) {

         int [] nums = {4,6,7,7};
        //Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        System.out.print(findSubsequences(nums));
    }



    static List<List<Integer>>  findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result.stream().collect(Collectors.toList());
    }

    static void backtrack(Set<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        if(temp.size() >= 2){
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if(temp.size() == 0 || temp.get(temp.size()-1) <= nums[i]){
                temp.add(nums[i]);
                backtrack(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }

        }
    }


    /**********************************************Method 2***********************************************************/

    public static List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private static void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1)
            res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }



}






