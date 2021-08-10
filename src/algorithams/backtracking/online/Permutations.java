package algorithams.backtracking.online;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {


    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }

    public static void permute(int[] nums,int l,List<List<Integer>> result){
        if(l == nums.length-1){
            List<Integer> curr = new ArrayList<>();
            for(int i:nums) curr.add(i);
            result.add(curr);
            return;
        }
        for (int i = l; i <= nums.length-1; i++) {
            swap(nums,l,i);
            permute(nums,l+1,result);
            swap(nums,l,i);
        }
    }

    public static void swap(int[] nums, int i, int r) {
        if(i == r)return;
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
    }
}
