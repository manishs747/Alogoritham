package recurssion;

/*
 * https://www.youtube.com/watch?v=eREiwuvzaUM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=7&t=0s
 * 
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 * 
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * 
 */

public class RecursiveStaircase {

	public static void main(String[] args) {
	

	}
	
	
	
	//3 power n
	public static int countPaths(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps == 0){
			return 1;
		}
		return countPaths(steps-1) + countPaths(steps-2) +countPaths(steps-3);
	}
	
	public static int countPathsMemo(int steps) {
		return countPathsMemo(steps,new int [steps+1]);
	}
	
	
	//time = n linear  space n    top down approch
	public static int countPathsMemo(int steps,int [] memo) {
		if (steps < 0) {
			return 0;
		} else if (steps == 0){
			return 1;
		}
		if (memo[steps] == 0) {
			memo[steps] = countPathsMemo(steps-1,memo) + countPathsMemo(steps-2,memo) +countPathsMemo(steps-3,memo);
		}
		return memo[steps];
	}
	
	//time = n linear  space n    Iterative   bottom up approach
	public static int countPathsDp(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps <= 1){
			return 1;
		}
		int [] paths = new int [steps+1];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;
		for (int i  = 3;i <= steps ;i++) {
			paths[i] =  paths[i-1] +  paths[i-2] +  paths[i-3];
		}
	return paths[steps];
}
	
	public static int countPathsDpIterative(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps <= 1){
			return 1;
		}
		int [] path = {1,1,2};
		for (int i  = 3;i <= steps ;i++) {
			int count  =  path[2] +  path[1] +  path[0];
			path[0] = path[1];
			path[1] = path[2];
			path[2] = count;
		}
		return path[2];
	}

}
