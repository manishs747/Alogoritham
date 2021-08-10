package dynamic_programming.leetocde;


/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {


    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        int[] arr1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};//6
        System.out.println(minCostClimbingStairsTopDown(arr1));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost,0);
    }

    public static int minCostClimbingStairs(int[] cost,int index) {
          if(index >= cost.length-1){
             return  0;
          }
          int c1 = cost[index] + minCostClimbingStairs(cost,index+1);
          int c2 = cost[index+1] + minCostClimbingStairs(cost,index+2); ;
          int c = Math.min(c1,c2);
        return c;
    }


    public static int minCostClimbingStairsTopDown(int[] cost) {
        return minCostClimbingStairsTopDown(cost,0,new int[cost.length+1]);
    }

    public static int minCostClimbingStairsTopDown(int[] cost,int index,int [] memo) {
        if(index >= cost.length-1){
            return  0;
        }
        if(memo[index] != 0){
            return memo[index];
        }
        int c1 = cost[index] + minCostClimbingStairsTopDown(cost,index+1,memo);
        int c2 = cost[index+1] + minCostClimbingStairsTopDown(cost,index+2,memo); ;
        return memo[index] = Math.min(c1,c2);
    }


    public int minCostClimbingStairsBottomUp(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
