package Array;
//Maximum difference between two elements such that larger element appears after the smaller number

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/



/*
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = 

Output : 2
Explanation : The maximum difference is between 9 and 7.
 */



public class MaximumDifference {

	public static void main(String[] args) {
		Integer [] arr = {34,8,10,3,2,8,0,30,33,1};
	//	Integer [] arr = {46158044, 9306314, 51157916, 93803496, 20512678, 55668109, 488932, 24018019, 91386538, 68676911, 92581441, 66802896, 10401330, 57053542, 42836847, 24523157, 50084224, 16223673, 18392448, 61771874, 75040277, 30393366, 1248593, 71015899, 20545868, 75781058, 2819173, 37183571, 94307760, 88949450, 9352766, 26990547, 4035684, 57106547, 62393125, 74101466, 87693129, 84620455, 98589753, 8374427, 59030017, 69501866, 47507712, 84139250, 97401195, 32307123, 41600232, 52669409, 61249959, 88263327, 3194185, 10842291, 37741683, 14638221, 61808847, 86673222, 12380549, 39609235, 98726824, 81436765, 48701855, 42166094, 88595721, 11566537, 63715832, 21604701, 83321269, 34496410, 48653819, 77422556, 51748960, 83040347, 12893783, 57429375, 13500426, 49447417, 50826659, 22709813, 33096541, 55283208, 31924546, 54079534, 38900717, 94495657, 6472104, 47947703, 50659890, 33719501, 57117161, 20478224, 77975153, 52822862, 13155282, 6481416, 67356400, 36491447, 4084060, 5884644, 91621319, 43488994, 71554661, 41611278, 28547265, 26692589, 82826028, 72214268, 98604736, 60193708, 95417547, 73177938, 50713342, 6283439, 79043764, 52027740, 17648022, 33730552, 42851318, 13232185, 95479426, 70580777, 24710823, 48306195, 31248704, 24224431, 99173104, 31216940, 66551773, 94516629, 67345352, 62715266, 8776225, 18603704, 7611906};
		//int [] arr = {7, 9, 5, 6, 3, 2};
		List<Integer> list = Arrays.asList(arr);
		System.out.println(maximumGapN(list));
	
	}
	
	
	
	public static int maxProfit(int[] prices) {
	     int max = 0;
	     int min = Integer.MAX_VALUE;
		 for (int i : prices) {
			 min = Math.min(min, i);
			 max = Math.max(max, i-min);
		 }
		return max;
	}
	
	
	/*https://www.interviewbit.com/problems/max-distance/
	 * https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
	 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
        If there is no solution possible, return -1.
	 * 
	 * A : [3 5 4 2]    Output : 2  for the pair (3, 4)
	 */
    public static int maximumGap(final List<Integer> A) {  //n 2 solution
       int maxDiff = -1;
       for (int i = A.size() -1; i >= 0  ; i--) {
    	   for (int j = 0; j <= i; j++) {
			if(A.get(i) >= A.get(j) && maxDiff < i -j ) {
				maxDiff = i - j ; 
				break;
			}
		   }
	   }
    	return maxDiff;
    }
    
    /*
     * linear solution time o(1) and space o(n)
     */
    
    public static int maximumGapN(final List<Integer> A) {
        int size = A.size();
     
        int []  lmin = new int[size];
        int []  lmax = new int[size];
        
        //filling lmin
        lmin[0] = A.get(0);
        for (int i = 1; i < lmax.length; i++) {
        	lmin[i] = Math.min(lmin[i-1], A.get(i));
		}
        
       // filling lmax
        lmax[lmax.length -1] = A.get(lmax.length -1);
        for (int i = lmax.length-2; i >= 0 ; i--) {
        	lmax[i] = Math.max(lmax[i+1], A.get(i));
		}
        
       int i = 0,j = 0,maxDiff = -1;
       while( i < size && j < size ) {
    	   if(lmin[i] <=  lmax[j]) {
    		   maxDiff = Math.max(maxDiff, j-i);
    		   j++;
    	   }else {
    		   i++;
    	   }
       }
     	return maxDiff;
     }
    
    public int maximumGapInterviewBit(final List<Integer> a) {
        int maxDiff;
        int i, j;
        int n = a.size();
     
        int[] LMin = new int[n];
        int[] RMax = new int[n];
     
       /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(a.get(i), LMin[i-1]);
     
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n-1] = a.get(n-1);
        for (j = n-2; j >= 0; --j)
            RMax[j] = Math.max(a.get(j), RMax[j+1]);
     
        /* Traverse both arrays from left to right to find optimum j - i
            This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = 0;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                maxDiff = Math.max(maxDiff, j-i);
                j = j + 1;
            }
            else
                i = i+1;
        }
     
        return maxDiff;
	}


	
	
	public static int maxDiff(int [] arr) {
		int maxDiff = 0;
	    int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				int diff = arr[j] - min;
				maxDiff = Math.max(maxDiff,diff);
			}
		return maxDiff;
	}
	

	public static int maxDiffN2(int [] arr) {
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int diff = arr[j] - arr[i];
				maxDiff = Math.max(maxDiff,diff);
			}
		}
		return maxDiff;
	}


}
