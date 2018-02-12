package dynamicProgramming;

//http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//Fn = Fn-1 + Fn-2       F0 = 0 and F1 = 1
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
public class fibonacci {

	public fibonacci() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int list = 10;
		int[] arr = new int[list];
	    for (int i = 1; i <list; i++) {
	    
	        System.out.println("Fibonacci for "+i+":"+fibdpor(i, arr));
		}*/
		int n = 50;
		long start = System.currentTimeMillis() % 1000;
		System.out.println(fib(n));
		long end = System.currentTimeMillis() % 1000;
		System.out.println(end - start);
	    
	}
	
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential
	//O(2 e n) 2 to power n
	//space complexity (n)
	static int fib(int n){
		if(n==0||n==1)
			return n;
		return fib(n-1)+fib(n-2);
	}
	
	/*
	 * Time Complexity: O(n)
        Extra Space: O(n)
        bottoms up approch
	 */
	static int fibdp(int n){
	    int f[] = new int[n+1];
	    f[0]=0;
	    f[1]=1;
	    for (int i = 2; i < n+1; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}
	
	//topDownApproac
	static int fibTopDown(int n){
	    int f[] = new int[n+1];
	    f[0]=0;
	    f[1]=1;
	    for (int i = 2; i < n+1; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}
	
	//fib dynamic programing optimsed space used using recurssion   Top - Down Approach :
		//Time Complexity: O(n)
	   // Extra Space: O(n)
			static int fibdpor(int n,int[] mem){
				if(n<=0)
					return 0;
				if(n==1){
					return 1;
				}
			    if(mem[n]==0){
			    	mem[n]=fibdpor(n-1,mem)+fibdpor(n-2,mem);
			    }
				return mem[n];
			}
	
	//fib dynamic programing optimsed space used using for loop
	static int fibdpo(int n){
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
	
	
	

}
