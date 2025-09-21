package algorithams.backtracking.neetcode;


import java.util.ArrayList;
import java.util.List;

import static algorithams.backtracking.online.LetterCombinations.dfs2;

/**
 * https://neetcode.io/problems/subsets?list=neetcode150
 */
public class Subsets {

    public static void main(String[] args) {
         int [] arr = {1,2,3};
        System.out.println(subsetsBackTracking(arr));
    }



    public static List<List<Integer>> subsetsBackTracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs2(nums,0,subset,result);
        return result;
    }



    public static void dfs(int[] nums,int i , List<Integer>subset , List<List<Integer>> result) {
        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums,i+1,subset,result);
        subset.remove(subset.size()-1);
        dfs(nums,i+1,subset,result);
    }

    private static void dfs2(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        // Explore further by trying all possible next elements
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs2(nums, i + 1, subset, result);  // move forward
            subset.remove(subset.size() - 1);   // backtrack
        }
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num:nums) {
            int size = result.size();
            for (int i = 0;i < size;i++) {
                ArrayList<Integer> local = new ArrayList<>(result.get(i));
                local.add(num);
                result.add(local);
            }
        }
        return result;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num:nums) {
            List<List<Integer>> tmpLists = new ArrayList<>(result);
            for (List<Integer>  tmpList: tmpLists) {
                List<Integer> tmp = new ArrayList<>(tmpList);
                tmp.add(num);
                result.add(tmp);
            }
        }
       return result;
    }


}
