package dynamic_programming.struckty;

import java.util.List;

public class NonAdjacentSum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 5, 12, 7);//4+12 = 16
        System.out.println(nonAdjacentSum(nums));;
    }

    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums,0,new int [nums.size()+1]);
    }

    public static int nonAdjacentSum(List<Integer> nums,int index,int [] memo ) {
        if(index >= nums.size()) return 0;
        if(memo[index] != 0) return memo[index];
        return memo[index] = Math.max(nums.get(index) +nonAdjacentSum(nums,index+2,memo) ,nonAdjacentSum(nums,index+1,memo));
    }
}
