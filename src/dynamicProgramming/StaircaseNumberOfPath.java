package dynamicProgramming;

import java.util.Map;
import java.util.concurrent.TimeUnit;

//http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
//https://algorithm.pingzhang.io/DynamicProgramming/unique_path.html
public class StaircaseNumberOfPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int steps = 10;
		long path = 0;
		path = countPathR(steps);
		System.out.println("Recursive solution:"+path);
		long[] memo = new long[steps+1];
		path = countPathMemo(steps, memo );
		System.out.println("Memo solution:"+path);
		path = countPathDp(steps) ;
		System.out.println("Iterative solution:"+path);
		countPathDp3Variable(steps);
		System.out.println("3 variable solution:"+path);
		
		
	}
	
	
	
	//complexity 3 power n
	public static long countPathR(int steps) {
       if(steps < 0){
    	   return 0;
       }
       if(steps == 0){
    	   return 1;
       }
		return countPathR(steps - 1) + countPathR(steps - 2)
				+ countPathR(steps - 3);
	}
	
	public static long countPathMemo(int steps,long [] memo) {
	       if(steps < 0){
	    	   return 0;
	       }
	       if(steps == 0){
	    	   return 1;
	       }
	       if(memo[steps] == 0){
	    	   memo[steps] =  countPathR(steps - 1) + countPathR(steps - 2)
						+ countPathR(steps - 3);
	       }
	       return memo[steps];
			
		}
	
	public static long countPathDp(int steps) {
		//case is imp to hand 1 0
		  if(steps < 0){
	    	   return 0;
	       }
	       if(steps <= 1){
	    	   return 1;
	       }
		long[] paths = {1,1,2};
		
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
