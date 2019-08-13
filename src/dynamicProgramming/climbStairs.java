package dynamicProgramming;
//Each time you can either climb 1 or 2 steps
public class climbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStair(4));
	}
	
	
	/*
	 * https://leetcode.com/problems/climbing-stairs/
	 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
	 */
	public static int climbStair(int n) {
		if(n < 0){
			return 0;
		}
		int a = 1;
		int b = 1;
		for (int i = 2; i <= n; i++) {
			int  path = a +  b;
			a = b;
			b = path;
		}
		return b;
	}

}
