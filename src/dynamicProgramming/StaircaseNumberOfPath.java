package dynamicProgramming;

import java.util.Map;
import java.util.concurrent.TimeUnit;

//http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
//https://algorithm.pingzhang.io/DynamicProgramming/unique_path.html


// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
//  https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
	
	
public class StaircaseNumberOfPath {

	public static void main(String[] args) {
		int steps = 3;
		long path = 0;
		path = countPathRecursive(steps);
		System.out.println("Recursive solution:"+path);
		long[] memo = new long[steps+1];
		path = countPathMemo(steps, memo );
		System.out.println("Memo solution:"+path);
		path = countPathDp(steps) ;
		System.out.println("Iterative solution:"+path);
		/*countPathDp3Variable(steps);
		System.out.println("3 variable solution:"+path);*/
		
		
	}
	
	//complexity 3 power n
		public static long countPathRecursive(int steps) {
	       if(steps < 0){
	    	   return 0;
	       }
	       if(steps == 0){
	    	   return 1;
	       }
			return countPathRecursive(steps - 1) + countPathRecursive(steps - 2)
					+ countPathRecursive(steps - 3);
		}
	

	//top down
	public static long countPathMemo(int steps,long [] memo) {
	       if(steps < 0){
	    	   return 0;
	       }
	       if(steps == 0){
	    	   return 1;
	       }
	       if(memo[steps] == 0){
	    	   memo[steps] =  countPathMemo(steps - 1,memo) + countPathMemo(steps - 2,memo)
						+ countPathMemo(steps - 3,memo);
	       }
	       return memo[steps];
		}
	
	//bottom up
	public static long countPathDp(int steps) {
		//case is imp to hand 1 0
		  if(steps < 0){
	    	   return 0;
	       }
	       if(steps <= 1){
	    	   return 1;
	       }
	     long[] paths = new long[steps +1];
	     paths[0] = 1;
		 paths[1] = 1;
		 paths[2] = 2;
		
		for (int i = 3; i < paths.length; i++) {
			paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
		}
		return paths[steps];
	}
	
	public static long countPathDp3Variable(int steps) {
		long[] paths = new long[3];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;
		
		for (int i = 3; i < paths.length; i++) {
			 long path = paths[0] + paths[1] + paths[2];
			 paths[0] = paths[1];
			 paths[1] = paths[2];
			 paths[2] = path;
		}
		return paths[2];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
