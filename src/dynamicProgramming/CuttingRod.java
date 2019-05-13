package dynamicProgramming;


//http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/

//https://www.youtube.com/watch?v=ElFrskby_7M


//cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}

/*
length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20     22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20       24 (by cutting in eight pieces of length 1)

*/


public class CuttingRod {

	public static final int price [] = {1, 5, 8, 9, 10, 17, 17, 20};
	//public static final int price [] = {3, 5, 8, 9, 10, 17, 17, 20};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	       // int size = arr.length;
	        //int result1 = cutRod(price, 8);
	      //  int result2 = memoizedCutRod(price, 8, new int [8]);
	       // System.out.println("Maximum Obtainable Value is "+result1);
	     /*  for (int i = 0; i < 9; i++) {
	    	   int result2 = memoizedCutRod(price, i, new int [i]);
			   System.out.println("MAx Out Put:"+i+" is "+result2);
		   }*/
		  
	        
		/* for (int i = 0; i < 9; i++) {
			  int result3 =  bottomUpCutRod(price, i);
		       System.out.println("bootom uP Result Out Put:"+result3);
		   }*/
		 int mem [] = new int [8];
		 int result3 =  memoizedCutRod(arr, 8,mem);
		 System.out.println(result3);
	        
	     

	}
	
	/* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
	//top-down, recursive manner
	static int cutRod(int[] prc,int n){
		if (n <= 0 || n > prc.length) return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0 ; i < n;i++) {
			max = Math.max(max, prc[i] + cutRod(prc, n-i-1));  //we are doing n-1 because for n = 1 ,price is at price[0]
		}
		return max;
	}
	
	
	//BOTTOM-UP-CUT-ROD   n square
	static int bottomUpCutRod(int[] prc,int n)
	{
	   if(n <= 0){
			return 0;
		}
		int[] mem = new int [n+1];
		for (int j = 1 ; j <= n;j++) {  //j is starting from 1 because cut can start from 1 only.
			int q = Integer.MIN_VALUE;
			for (int i = 0; i < j; i++) {
				q = Math.max(q, prc[i]+mem[j-1-i]); //we are doing n-1 because for n = 1 ,price is at price[0]  and also because i starts from zero
			}
			mem[j] = q;
		}
		return mem[n];
	}
	
	
	//MEMOIZED-CUT-ROD-AUX AUX.p;n;r/
	//TOP down approch
	static int memoizedCutRod(int[] prc,int n,int [] mem)
	{
		if(n <= 0){
			return 0;
		}
		if (mem[n-1]==0) {
			int q = Integer.MIN_VALUE;
			for (int i = 0 ; i < n;i++) {
				q = Math.max(q, prc[i] + memoizedCutRod(prc, n-1-i,mem));  //we are doing n-1 because for n = 1 ,price is at price[0]
			}
			mem[n-1] = q;
		}
		return mem[n-1];
	}

	
	

	
	
}
