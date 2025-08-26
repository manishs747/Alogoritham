package dynamic_programming.neetcode;

public class MinCostClimbing {

    public static void main(String[] args) {
        int []cost = {1,100,1,1,1,100,1,1,100,1} ;//6
        System.out.println(minCostClimbingStairs(cost));
    }


    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost,-1);
    }

    public static int minCostClimbingStairs(int[] cost ,int curloc) {
         if(curloc +1  >= cost.length)   return 0;
         int  cost1 = cost[curloc+1] + minCostClimbingStairs(cost , curloc+1) ;
         int  cost2 = Integer.MAX_VALUE;
         if(curloc+2 < cost.length){
             cost2 = cost[curloc+2] + minCostClimbingStairs(cost , curloc+2) ;
         }
        return Math.min(cost1,cost2);
    }
}
