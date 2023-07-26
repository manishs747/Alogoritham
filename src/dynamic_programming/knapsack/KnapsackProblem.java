package dynamic_programming.knapsack;

/*
 * https://www.geeksforgeeks.org/knapsack-problem/
 * 
    https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
 *
 * https://www.interviewbit.com/problems/0-1-knapsack/
 * https://www.youtube.com/watch?v=xCbYmUPvc2Q
 *
 * https://www.youtube.com/watch?v=nLmhmB6NzcM
 * https://www.youtube.com/watch?v=cJ21moQpofY
 *
 *
 * 
 * 
 * 
 */

public class KnapsackProblem {

	public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println("Total knapsack profit  for 5 wt---> " + solveKnapsackBottomUpDownOptimized2(profits, weights, 5)); //17
        System.out.println("Total knapsack profit  for 6 wt---> " + solveKnapsackBottomUpDownOptimized2(profits, weights, 6)); //17
        System.out.println("Total knapsack profit  7 wt---> " + solveKnapsackBottomUpDownOptimized2(profits, weights, 7));//22
	}


    public static int solveKnapsackTopDown(int[] profits, int[] weights, int capacity) {
        int[][] memo = new int[profits.length][capacity +1];
        return solveKnapsackTopDown(profits,weights, capacity,0,memo);
    }

    public static int solveKnapsackTopDown(int[] profits, int[] weights, int capacity, int index, int[][] memo) {
	    if(capacity <= 0 || index >= profits.length){
	        return 0;
        }
	    String key = capacity+"_"+index;
	    if(memo[index][capacity] != 0){
	        return memo[index][capacity];
        }
	    int profit = 0;
	    if(weights[index] <= capacity){
            profit = profits[index] + solveKnapsackTopDown(profits,weights,capacity - weights[index],index+1,memo);
        }
        memo[index][capacity] = Math.max(profit, solveKnapsackTopDown(profits,weights,capacity,index+1,memo));
        return memo[index][capacity];

    }

    /******************************************BOTTOM UP************************************************************************/


    public static int solveKnapsackBottomUpDown(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int wtIndex = profits.length;
        int[][] memo = new int[wtIndex][capacity + 1];
        for(int i = weights[0]; i < capacity;i++){
                memo[0][i] = profits[0];
        }
        for(int i = 1; i < memo.length;i++){
            for (int c = 1;c < memo[0].length;c++){ //c == capacity
                int profit = 0;
                if( c >= weights[i] ){ //capacity is grater equal than wt
                    profit = profits[i] + memo[i-1][c-weights[i]];
                }
                memo[i][c] = Math.max(profit,memo[i-1][c]);
            }
        }
        return memo[wtIndex-1][capacity];
    }

    public static int solveKnapsackBottomUpDown1(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int wtIndex = profits.length;
        int[][] memo = new int[wtIndex][capacity + 1];
        for(int i = weights[0]; i < capacity;i++){
            memo[0][i] = profits[0];
        }
        for(int i = 1; i < memo.length;i++){
            for (int cap = 1;cap < memo[0].length;cap++){
                int profitWC = memo[i-1][cap];
                memo[i][cap] =  cap >= weights[i] ? Math.max(profits[i] + memo[i-1][cap-weights[i]],profitWC):profitWC;
            }
        }
        return memo[wtIndex-1][capacity];
    }


    /**
     * We only need one previous row to find the optimal solution!
     */
    public static int solveKnapsackBottomUpDownOptimized1(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int wtIndex = profits.length;
        int[] prev = new int[capacity + 1];
        int[] cur = new int[capacity + 1];
        for (int i = weights[0]; i < capacity; i++) {
            prev[i] = profits[0];
        }
        for (int i = 1; i < wtIndex; i++) {
            for (int cap = 1; cap < capacity + 1; cap++) {
                int profitWC = prev[cap];
                cur[cap] = cap >= weights[i] ? Math.max(profits[i] + prev[cap - weights[i]], profitWC) : profitWC;
            }
            int[] tmp = cur;
            cur = prev;
            prev = tmp;
        }
        return prev[capacity];
    }


    /**
     * We only need one previous row to find the optimal solution!
     */
    public static int solveKnapsackBottomUpDownOptimized2(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int wtIndex = profits.length;
        int[][] memo = new int[2][capacity + 1];
        for (int i = weights[0]; i < capacity; i++) {
            memo[0][i] = profits[0];
        }
        for (int i = 1; i < wtIndex; i++) {
            for (int cap = 1; cap < capacity + 1; cap++) {
                int profitWC = memo[(i-1)%2][cap];
                memo[i%2][cap] = cap >= weights[i] ? Math.max(profits[i] + memo[(i-1)%2][cap - weights[i]], profitWC) : profitWC;
            }
        }
        return memo[(wtIndex-1)%2][capacity];
    }


    /**
     * Best
     * We only need one array if we start from end
     */
    public static int solveKnapsackBottomUpDownOptimized3(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int wtIndex = profits.length;
        int[] memo = new int[capacity + 1];
        for (int i = weights[0]; i < capacity; i++) {
            memo[i] = profits[0];
        }
        for (int i = 1; i < wtIndex; i++) {
            for (int cap = capacity; cap > 0; cap--) {
                int profitWC = memo[cap];
                memo[cap] = cap >= weights[i] ? Math.max(profits[i] + memo[cap - weights[i]], profitWC) : profitWC;
            }
        }
        return memo[capacity];
    }



}
