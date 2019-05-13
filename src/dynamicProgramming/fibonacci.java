package dynamicProgramming;

import java.math.BigInteger;

//http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//Fn = Fn-1 + Fn-2       F0 = 0 and F1 = 1
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*	int list = 10;
		int[] arr = new int[list];
	    for (int i = 1; i <list; i++) {

	        System.out.println("Fibonacci for "+i+":"+fibdpor(i, arr));
		}*/
		int n = 35;
		long start = System.currentTimeMillis() % 1000;
		System.out.println(fib(n));
		long end = System.currentTimeMillis() % 1000;
		System.out.println(end - start);

	}


	//Recursive solution  
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential  = O(2 e n) 2 to power 
	//space complexity (n) for recurssion stack
	static int fib(int n){
		if(n==0||n==1)
			return n;
		return fib(n-1)+fib(n-2);
	}

	/***************************************************************************************************************************************/
	//TOP DOWN    easier solution  think recursive and then just add check
	//fib dynamic programing optimsed space used using recurssion   Top - Down Approach :
	//Time Complexity: O(n)
	// Extra Space: O(n)  we are doing same as recursive solution except if just check its already solved
	static int fibTopDown(int n,int[] mem){
		if(n==0||n==1)
			return n;
		if(mem[n]==0){
			mem[n]=fibTopDown(n-1,mem)+fibTopDown(n-2,mem);
		}
		return mem[n]; 
	}

	/***************************************************************************************************************************************/
	/*   BOTTOMS up approch
        Extra Space: O(n)    Time Complexity: O(n)

	 */
	static int fibBottomUpArr(int n){
		int f[] = new int[n+1];
		f[0]=0;
		f[1]=1;
		for (int i = 2; i < n+1; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}

	/***************************************************************************************************************************************/
	//Bottoms UP

	//fib dynamic programing optimsed space used using for loop
	static int fibBottomUp(int n){
		int a = 0, b = 1, sum = 0;
		if(n==0||n==1)
			return n;
		for (int i = 2; i < n+1; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
	/***************************************************************************************************************************************/
	//https://www.hackerrank.com/challenges/fibonacci-modified/problem
	static BigInteger fibonacciModified(int t1, int t2, int n) {
		BigInteger prev, current, sum = null;
		if (n == t1) return new BigInteger(t1+"");
		if (n == t2) return  new BigInteger(t2+"");
		prev =  new BigInteger(t1+"");
		current = new BigInteger(t2+"");
		for (int i = 2 ; i < n;i++) {
			sum =  current.multiply(current).add(prev) ;
			prev = current;
			current = sum;
		}
		return sum;
	}




}
