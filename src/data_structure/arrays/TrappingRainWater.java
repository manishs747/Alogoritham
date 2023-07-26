package data_structure.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//http://www.geeksforgeeks.org/trapping-rain-water/
//https://www.hackerrank.com/contests/knitopencontest/challenges/rain-harvester
public class TrappingRainWater {
	
   
   

	public static void main(String[] args) {
		
		int a[] = {2,1,3,1,2,2,1};
		int a1[] = {0,1,0,2,1,0,1,3,2,1,2,1}; //return 6 
		int a2[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};  ///9
		int a3[] = {3,0,0,2,0,4};//10
		
		 List<int[]> myList = getList();
		 for (int[] arr : myList) {
			 
			System.out.println(getRainHarvestedMemmorySolution(arr));
		}
		
		//System.out.println(getTrappedWater(a1));
		
	}
	
	
	public static int getTrappedWater(int[] arr) {
		int water = 0;
		int leftMax = 0;
		int rightMax = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int b = arr[i];
			leftMax = Math.max(leftMax, b);
			rightMax = getMaxAfter(arr, i);
			// System.out.println("Right MAx for "+b+" is "+rightMax)
			water = water + Math.min(leftMax, rightMax) - b;
		}
		return water;
	}
	
	public static int getMaxAfter(int[] arr, int after) {
		int max = 0;
		for (int i = after ; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		//System.out.println("MAX for "+arr[after]+ " is "+max);
		return max;
	}
	
	//O(N) solution
	public static int getTrappedWaterMemmorySolution(int[] arr) {
		 int n = arr.length;
	        if (n < 2)
	            return 0;
	        
	        int left[] = new int[n];
	        int right[] = new int[n];
	        int water = 0;
	        
	        left[0] = arr[0];
	        for (int i = 1; i < left.length; i++) {
	        	left[i]= Math.max(arr[i],left[i-1] );
			}
	        
	        right[n-1] = arr[n-1];
	        for (int i = n-2; i >= 0; i--) {
				right[i] = Math.max(arr[i], arr[i+1]);
			}
	      
	        for (int i = 0; i < right.length; i++) {
	        	water += Math.min(left[i],right[i]) - arr[i];
			}
		return water;
	}
	
	/*
2
3
4 2 1
6
1 1 5 4 3 2 


3
11
	 */
	public static List<int[]> getList() {
		Scanner in = new Scanner(System.in);
		int numberOfInput = in.nextInt();
		List<int[]> myList = new ArrayList<int[]>();
		for (int i = 0; i < numberOfInput; i++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = in.nextInt();
			}
			myList.add(arr);
		}
		return myList;
	}
    
	//O(N2)
	public static int getRainHarvested(int[] arr) {
		int water = 0;
		int leftMax = 0;
		int rightMax = 0;
		for (int i = 0; i < arr.length; i++) {
			int b = arr[i];
			rightMax = getMaxAfter(arr, i);
			water = water + Math.min(leftMax, rightMax);
			leftMax = Math.max(leftMax, b);
		}
		return water;
	}
	
	public static int getRainHarvestedMemmorySolution(int[] arr) {
		int n = arr.length;
        if (n < 2)
            return 0;
        
        int left[] = new int[n];
        int right[] = new int[n];
        int water = 0;
        
        left[0] = 0;//excluding current ellement
        for (int i = 1; i < left.length; i++) {
        	left[i]= Math.max(arr[i-1],left[i-1] );
		}
       
        right[n-1] = arr[n-1];//including current ellement
        for (int i = n-2; i >= 0; i--) {
			right[i] = Math.max(arr[i], right[i+1]);
		}
        
        for (int i = 0; i < right.length; i++) {
        	water += Math.min(left[i],right[i]);
		}
		return water;
	}
	
	

}
