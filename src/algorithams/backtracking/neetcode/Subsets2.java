package algorithams.backtracking.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args){
        int list [] = {1,1,2};
        System.out.println(subsetsWithDup(list));
    }



    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),result);
        return result;
    }

    public  static void  dfs(int[] nums , int index,List<Integer> subset,List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums,index+1,subset,result);
        subset.remove(subset.size()-1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums,index+1,subset,result);

    }
}
