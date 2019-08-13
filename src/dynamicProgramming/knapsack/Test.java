package dynamicProgramming.knapsack;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		int wt [] = {1,2,3,5};
		int val [] = {1,6,10,16};

		int recursive = knapSackRecursiveTopDown( wt,val, 7);
		System.out.println(recursive);
	}
	
	static int knapSackRecursiveTopDown( int wt[], int val[],int w) {
		Map<String,Integer> memo = new HashMap<>();
		return knapSackRecursiveTopDown(wt, val, w, wt.length-1,memo);
	}
	
	
	static int knapSackRecursiveTopDown(int wt[], int val[],int capacity,int index,Map<String,Integer> memo) {
		if(  capacity <= 0 || index < 0  )  {
			return 0;
		}
		String key = capacity+"_"+index;
		if(!memo.containsKey(key)) {
			int priceIncluding = 0;
			if(capacity >= wt[index]) {
				priceIncluding = val[index]+knapSackRecursiveTopDown(wt, val, capacity-wt[index], index-1,memo);
			}
			int priceExcluding = knapSackRecursiveTopDown(wt, val, capacity, index-1,memo);
			memo.put(key, Math.max(priceIncluding, priceExcluding));
		}
		return memo.get(key);
	}
	

}
