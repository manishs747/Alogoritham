package dynamicProgramming.knapsack;

import java.util.HashMap;
import java.util.Map;


/*
 * https://www.geeksforgeeks.org/knapsack-problem/
 * 
 * 
 * https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 * 
 * https://www.youtube.com/watch?v=qOUsP4eoYls
 * 
 * https://www.youtube.com/watch?v=PLJHuErj-Tw&list=PLW1OMpQZxu7z9d3aajQ0EerthCGaE3QLS&index=9
 * 
 * https://www.youtube.com/watch?v=xOlhR_2QCXY&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2&t=2s
 * 
 * https://www.educative.io/collection/page/5668639101419520/5633779737559040/5666387129270272?affiliate_id=5082902844932096&utm_source=google&utm_medium=cpc&utm_campaign=platform2&utm_content=ad-1-dynamic&gclid=CjwKCAjw_YPnBRBREiwAIP6TJ67VqRrliI87Lvk30NA3U1jg9Z2r-evg6tcQo8zkPlsrj2s7B-U-JhoCojsQAvD_BwE
 * 
 * 
 * https://www.youtube.com/watch?v=xCbYmUPvc2Q
 * 
 * https://www.youtube.com/watch?v=xOlhR_2QCXY
 * 
 * 
 */

public class KnapsackProblem {

	public static void main(String[] args) {
		//int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
		//	int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
		int val1 [] = {1,4,5,7};
		int wt1 [] = {1,3,4,6};

		int wt2 [] = {2,3,1,4};
		int val2 [] = {4,5,3,7};

		int recursive = knapsackDpTopDownArr( wt2, val2,5);
		System.out.println(recursive);

		/*	int r = bottomUpDP(val, wt, 30);
		int r1 = topDownRecursive(val, wt, 30);
		System.out.println(r);
		System.out.println(r1);*/

	}
	/**********************************************RECURSIVE TOP DOWN ***********************************************************************************/
	//O(​2 exp n)  manish
	static int knapSackRecursiveTopDown( int wt[], int val[],int w) {
		return knapSackRecursiveTopDown(wt, val, w, wt.length-1);
	}

	static int knapSackRecursiveTopDown(int wt[], int val[],int capacity,int index) {
		if(  capacity <= 0 || index < 0  )  {
			return 0;
		}
		int priceIncluding = 0;
		if(capacity >= wt[index]) {
			priceIncluding = val[index]+knapSackRecursiveTopDown(wt, val, capacity-wt[index], index-1);
		}
		int priceExcluding = knapSackRecursiveTopDown(wt, val, capacity, index-1);
		return Math.max(priceIncluding, priceExcluding);
	}
	/**********************************************RECURSIVE BOTTOM UP *********************************************************************************/

	static int knapsackRecursiveBottomUp( int wt[], int val[],int w) {
		return knapsackRecursiveBottomUp(wt, val, w, 0);
	}

	private static int knapsackRecursiveBottomUp(int[] weights,int[] profits, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;
		int priceIncluding = 0;
		if( capacity >= weights[currentIndex] )
			priceIncluding = profits[currentIndex] + knapsackRecursiveBottomUp( weights,profits,capacity - weights[currentIndex], currentIndex + 1);	
		int priceExcluding = knapsackRecursiveBottomUp( weights,profits, capacity, currentIndex + 1);
		return Math.max(priceIncluding, priceExcluding);
	}
	/******************************************DP TOP DOWN HASHMAP ******************************************************************************************************/

	//O(N∗C).  time
	//SPACE O(N∗C).

	static int knapSackDpTopDown( int wt[], int val[],int w) {
		Map<String,Integer> memo = new HashMap<>();
		return knapSackDpTopDown(wt, val, w, wt.length-1,memo);
	}

	static int knapSackDpTopDown(int wt[], int val[],int capacity,int index,Map<String,Integer> memo) {
		if(  capacity <= 0 || index < 0  )  {
			return 0;
		}
		String key = index+"_"+capacity;
		if(!memo.containsKey(key)) {
			int priceIncluding = 0;
			if(capacity >= wt[index]) {
				priceIncluding = val[index]+knapSackDpTopDown(wt, val, capacity-wt[index], index-1,memo);
			}
			int priceExcluding = knapSackDpTopDown(wt, val, capacity, index-1,memo);
			memo.put(key,  Math.max(priceIncluding, priceExcluding));
		}
		return memo.get(key);
	}
	

	/******************************************DP TOP DOWN HASHMAP***********************************************************************************************************/
	public static int knapsackDpTopDownArr( int[] weights,int[] profits, int capacity) {
		int[][] memo = new int[profits.length][capacity + 1];
		return knapsackDpTopDownArr(weights,profits, capacity, 0,memo);
	}

	private static int knapsackDpTopDownArr(int[] weights,int[] profits, int capacity,int currentIndex,int[][] memo) {

		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		// if we have already solved a similar problem, return the result from memory
		if(memo[currentIndex][capacity] == 0) {
			// recursive call after choosing the element at the currentIndex
			// if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
			int profit1 = 0;
			if( weights[currentIndex] <= capacity )
				profit1 = profits[currentIndex] + knapsackDpTopDownArr(  weights,profits,capacity - weights[currentIndex], currentIndex + 1,memo);
			// recursive call after excluding the element at the currentIndex
			int profit2 = knapsackDpTopDownArr(  weights, profits,capacity, currentIndex + 1,memo);
			memo[currentIndex][capacity] = Math.max(profit1, profit2);
		}
		return memo[currentIndex][capacity];
	}


	/******************************************BottomsUpDP******************************************************************************************************/

	public static int solveKnapsackBottomsUpDP(int[] profits, int[] weights, int capacity) {
		// base checks
		if(capacity <= 0 ||profits.length == 0 ||  profits.length != weights.length ) {
			return 0;
		}
		
		 int n = profits.length;
		 int[][] dp = new int[n][capacity + 1];
		 
		 // populate the capacity=0 columns, with '0' capacity we have '0' profit
		    for(int i=0; i < n; i++)
		      dp[i][0] = 0;
		  
		    // if we have only one weight, we will take it if it is not more than the capacity
		    for(int c=0; c <= capacity; c++) {
		      if(weights[0] <= c)
		        dp[0][c] = profits[0];
		    }
		 
		 // process all sub-arrays for all the capacities
		    for(int i=1; i < n; i++) {
		      for(int c=1; c <= capacity; c++) {
		        int profit1= 0, profit2 = 0;
		        // include the item, if it is not more than the capacity
		        if(weights[i] <= c)
		          profit1 = profits[i] + dp[i-1][c-weights[i]];
		        // exclude the item
		        profit2 = dp[i-1][c];
		        // take maximum
		        dp[i][c] = Math.max(profit1, profit2);
		      }
		    }
		    // maximum profit will be at the bottom-right corner.
		    return dp[n-1][capacity];
	}
	


}
