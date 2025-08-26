package algorithams.backtracking.online.permuation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * https://www.educative.io/courses/grokking-coding-interview/introduction-to-backtracking
 *
 */
public class Permutations {

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums,0,list);
        return list;
    }

    public static void permute(int[] nums, int index ,List<List<Integer>> memo ){
        if(index == nums.length-1){
            List<Integer> curr = new ArrayList<>();
            for(int i:nums) curr.add(i);
            memo.add(curr);
            return;
        }
        for(int i = index ; i < nums.length;i++){
            swap(nums,index,i);
            permute(nums,index+1,memo);
            swap(nums,index,i);
        }
    }

    private static void swap(int[] nums, int index, int i) {
        int tmp = nums[index];
        nums[index]=nums[i];
        nums[i] = tmp;
    }

}
