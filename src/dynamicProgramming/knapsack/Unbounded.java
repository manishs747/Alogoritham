package dynamicProgramming.knapsack;

/*
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 * 
 * https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 * 
 * 
 * 
 * 
 */
public class Unbounded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			   /*  int   val[] = {50,100,140};
			     int wt[]  = {2,3,5};*/ 
			     
			     int   val[] = {10, 40, 50, 70};
			     int wt[]  = {1, 3, 4, 5}; 
			     System.out.println(unboundedKnapsack(wt, val, 8));
			     
			//Output : 110

	}
	
	/*
	 *  int weight[] = {2,3,5} /{50,100,140}  k= 17   ANS:550
        {1, 3, 4, 5}/{10, 40, 50, 70}  k=8  ANS=110
	 * 
	 * 
	 */
	static int unboundedKnapsack( int[] wt,int [] val,int k) {
		int sum = 0;
		while(k >= 0) {
			int maxIndex = -1;
			for(int i = 0;i<wt.length;i++) {
				if(k - wt[i] >=0) {
					if(maxIndex == -1) {
						maxIndex = i;
					}else {
						maxIndex =  val[i]/wt[i] > val[maxIndex]/wt[maxIndex] ?i:maxIndex;
					}
				}
			}
			if(maxIndex == -1) {
				break;
			}
			System.out.println("Selected:"+wt[maxIndex]);
			k = k -wt[maxIndex];
			sum = sum+val[maxIndex];
		}
		return sum;
	}
	 
	 
	 
	 
	
	static int knapSackRecursiveTopDown( int wt[], int val[],int w) {
		return knapSackRecursiveTopDown(wt, val, w, wt.length-1);
	}

	static int knapSackRecursiveTopDown(int wt[], int val[],int capacity,int index) {
		if(  capacity <= 0 || index < 0  )  {
			return 0;
		}
		int priceIncluding = 0;
		if(capacity >= wt[index]) {
			priceIncluding = val[index]+knapSackRecursiveTopDown(wt, val, capacity-wt[index], index-1);
		}
		int priceExcluding = knapSackRecursiveTopDown(wt, val, capacity, index-1);
		return Math.max(priceIncluding, priceExcluding);
	}

}
