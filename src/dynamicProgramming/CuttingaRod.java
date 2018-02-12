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


public class CuttingaRod {

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
		 int result3 =  memoizedCutRod( 8,mem);
		 System.out.println(result3);
	        
	     

	}
	
	/* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
	//top-down, recursive manner
	static int cutRod(int[] prc,int n)
	{
		if(n==-1){
			return 0;
		}
		int max = 0 ;
		for(int i=0;i<n;i++){
			max = Math.max(max,prc[i]+cutRod(prc, n-1-i) ) ;
		}
		System.out.println("MAX FOR:"+n+" = "+ max);
		return max;
	}
	
	//MEMOIZED-CUT-ROD-AUX AUX.p;n;r/
	//top down approch
	static int memoizedCutRod(int n,int [] mem)
	{
     	if(n <= 0){
			return 0;
		}
     	if(mem[n-1] > 0){
     		return mem[n-1];
     	}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			max = Math.max(max,price[i]+memoizedCutRod(n-1-i,mem) ) ;
		}
		mem[n-1] = max;
		return max;
	}
	
	//BOTTOM-UP-CUT-ROD.p;n/

	static int bottomUpCutRod(int[] prc,int n)
	{
	   if(n <= 0){
			return 0;
		}
		int[] mem = new int [n+1];
		mem[0] = 0;
		for(int i=1;i<=n;i++){
			int max = -1;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max,price[j-1]+mem[i-j]) ;
				//System.out.println("MAX value for i="+i+" and j="+j+"  price[j-1]:"+price[j-1]+" is "+max);
			}
			//System.out.println("MAX value for i:"+num+" is "+max);
			mem[i] = max;
		}
	//	System.out.println("MAX FOR:"+n+" = "+ mem[n]);
		return mem[n];
	}
	
	
}
