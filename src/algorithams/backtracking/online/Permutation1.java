package algorithams.backtracking.online;


import utils.ArrayUtils;

import static algorithams.backtracking.online.Permutations.swap;

/**
 * https://www.educative.io/courses/grokking-coding-interview-patterns-java/backtracking-introduction
 */
public class Permutation1 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        permuteArr(nums);
    }

    private static void permuteArr(int[] nums) {
        permuteArr(nums,0);

    }

    private static void permuteArr(int[] nums , int start) {
         if(start == nums.length){
             ArrayUtils.print(nums);
             return;
         }
        for (int i = start; i < nums.length ; i++) {
            swap(nums,start,i);
            permuteArr(nums,start+1);
            swap(nums,start,i);
        }

    }
}
