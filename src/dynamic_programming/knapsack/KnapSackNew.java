package dynamic_programming.knapsack;

public class KnapSackNew {

    public static void main(String[] args) {

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println("Total knapsack profit  for 5 wt---> " + solveKnapsackTopDown(profits, weights, 5)); //16
        System.out.println("Total knapsack profit  for 6 wt---> " + solveKnapsackTopDown(profits, weights, 6)); //17
        System.out.println("Total knapsack profit  7 wt---> " + solveKnapsackTopDown(profits, weights, 7));//22
    }


    public static int solveKnapsackTopDown(int[] profits, int[] weights, int capacity) {
        return solveKnapsackTopDownHelper(profits,weights,capacity,0);
    }

    public static int solveKnapsackTopDownHelper(int[] profits, int[] weights, int capacity,int index) {
         if( capacity <= 0 || index >= profits.length) return 0;
         int profit = 0;
         if(weights[index] <= capacity){
              profit = profits[index] + solveKnapsackTopDownHelper(profits,weights,capacity-weights[index],index+1);
         }
         profit = Math.max(profit,solveKnapsackTopDownHelper(profits,weights,capacity,index+1));
         return profit;
    }

    /**
     *
     *https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
     * https://www.youtube.com/watch?v=IRwVmTmN6go
     * https://www.educative.io/courses/dynamic-programming-in-python/B8wxRR8GWON
     */
    public static class RodCutting {

        public static void main(String[] args) {

        }


        public int minCost(int n, int[] cuts) {



            return -1;
        }



    }
}
