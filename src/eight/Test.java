package eight;

public class Test {

	public static void main(String[] args) {
		int [] apples = {2};
		int [] oranges = {-2};
		
		countApplesAndOranges(2, 3, 1, 5,apples , oranges);

	}
	/*
	 *  10 2 3
		3 1
		5 2 8     Ans 9
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
     
       
  
       int k = 0;
       int d = 0;
       
       int sum = -1;
       while(k < keyboards.length || d < drives.length ) {
    	 int  ks = keyboards[k];
    	  int ds = drives[d];
    	  if(ks+ds <= ds) {
    		  sum = Math.max(sum, ks+ds);
    	  }
    	
    	   
       }
       return sum;
    }
	
	
	 // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    	 int m = 0;
    	 int n = 0;
    	 for (int apple:apples) {
    		 int al = a+apple;
    		 if (al >= s && al <= t) {
    			 m++;
    		 }
		  }
    	 for (int orange:oranges) {
    		 int ol = b+orange;
    		 if (ol >= s && ol <= t) {
    			 n++;
    		 }
    	 }
       System.out.println(m);
       System.out.println(n);
    }

}
