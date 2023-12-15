package dynamic_programming.leetocde.jump_game;


/**
 * https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(jump(arr));
    }

    public static  int jump(int[] nums) {
        return jump(nums,0,new Integer  [nums.length]);
    }

    public static  int jump(int[] nums,int index,Integer[] memo ) {
        if(index == nums.length-1) return 0;
        if(memo[index] != null) return memo[index];
        int minJump = Integer.MAX_VALUE;
        for (int i = 1; index+ i < nums.length && i <= nums[index] ; i++) {
            minJump = Math.min(minJump,jump(nums,index+i,memo)) ;
        }
        return memo[index] = minJump == Integer.MAX_VALUE ? minJump:minJump+1;
    }
}
