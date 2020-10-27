package data_structure.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FindKthSmall {
	
	//https://www.hackerrank.com/contests/snapdeal-codesprint/challenges/kth-largest-smallest-number/problem
	/*\
	 *input
	 *9 3
	  1 2 3 4 5 6 7 9 10
      2 3 0
      7 4 1
      5 1 0
	 *
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		    int arrSize = in.nextInt();
		    int numOfQuery = in.nextInt();
		    int array[] = new int [arrSize];
		    for (int i = 0; i < arrSize; i++) {
		    	array[i] = in.nextInt();
			}
           for (int i = 0; i < numOfQuery; i++) {
			int index = in.nextInt();
			int kth = in.nextInt();
			int isSmall = in.nextInt();
			System.out.println(getCustomKth(array, index, kth, isSmall));
			
		}
	}
	
	
	
	
	public static int getCustomKth(int array[],int index,int kth,int isSmall ){
		int arrStart = 0;
		int arrEnd = array.length-1;
		int effectiveIndex = 0;
		
		if(isSmall == 0){
			while(array[arrStart] < index){
				arrStart++;
			}
			effectiveIndex = arrStart + kth;
		}else{
			while(array[arrEnd] > index){
				arrEnd--;
			}
			effectiveIndex = arrEnd - kth;
			
		}
		return array[effectiveIndex];
		
	}
	
	
	
	
	/**
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int kthSmallest(Integer[] arr, int k) {
		 // Sort the given array
        Arrays.sort(arr);
        // Return k'th element in 
        // the sorted array
        return arr[k-1];

	}

}
