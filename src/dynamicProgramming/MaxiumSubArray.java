package dynamicProgramming;

import java.util.Scanner;

//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//https://www.hackerrank.com/challenges/maxsubarray

/*
 * 
 input
2 
4 
1 2 3 4
6
2 -1 2 3 4 -5


output

10 10
10 11

 */

//-2,-3,4,-1,-2,1,,5,-3       answer 7


/*
 input
6
1
1
6
-1 -2 -3 -4 -5 -6
2
1 -2
3
1 2 3
1
-10
6
1 -1 -1 -1 -1 5

output
1 1
-1 -1
1 1
6 6
-10 -10
5 6
 */

/*
1 1
-1 0
1 1
6 6
-10 0
5 6
 */


public class MaxiumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2 ,-1, 0, -3};
		int b[] = {-2, -1, 4, -1, -2, 1, 5, -3};
		
		// System.out.println(getMax(b));
		// System.out.println(getMaxold(b));
		System.out.println(getNoncontMaxSubarray(a));
		
		//getInputAndCall();
		
		
	}
	
	

	//dynamic programing  best
	public static int getMax(int a[]){
		   int max_so_far = a[0];
		   int curr_max = a[0];
		   for (int i = 1; i < a.length; i++)
		   {
		        curr_max = Math.max(a[i], curr_max+a[i]);
		        max_so_far = Math.max(max_so_far, curr_max);
		        System.out.println("C_ELEMT:"+a[i]+" MAX_CUR:"+curr_max+" MAX_SF:"+max_so_far);
		   }
		   return max_so_far;
	}

	private static void getInputAndCall() {
		Scanner in = new Scanner(System.in);
		int numOfInput = in.nextInt();
		for(int i= 0; i < numOfInput; i++) {
			int arrSize = in.nextInt();
			int[] input = new int[arrSize];
			for (int j = 0; j < arrSize; j++) {
				input[j] = in.nextInt();
			}
			System.out.print(getMax(input));
			System.out.print(" ");
			System.out.println(getNoncontMaxSubarray(input));
		}
	}

	//doesnt handle all negative solution
	private static int getMaxold(int[] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i : arr) {
			max_ending_here = max_ending_here + i;
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
	
	
	
	public static int getNoncontMaxSubarrayOld(int a[]){
		int sum = a[0];
		 for (int i = 1; i < a.length; i++)
		   {
		        if(a[i]>0){
		        	sum+=a[i];
		        }
		   }
		 return sum;
	}
	
	public static int getNoncontMaxSubarray(int a[]){
		int sum = a[0];
		 for (int i = 1; i < a.length; i++)
		   {
		      /*  if((sum + a[i]) > a[i]){
		        	sum+=a[i];
		        }*/
			if (a[i] > 0) {
				sum += a[i];
			} else if (sum < a[i]) {
				sum = a[i];
			}
			
		   }
		 return sum;
	}
	
	
	

}
