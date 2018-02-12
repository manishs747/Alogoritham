package stack.equalStack;

import java.util.Scanner;
import java.util.stream.IntStream;

public class equalStackNonStackSolution {
	
	/*
	 * 
3 2 1 1 1
4 3 2
1 1 4 1
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner in = new Scanner(System.in);
	        int n1 = in.nextInt();
	        int n2 = in.nextInt();
	        int n3 = in.nextInt();
	        int[] h1 = new int[n1];
	        int sum1 = 0;
	        for(int i=0; i < n1; i++){
		          int num = in.nextInt();
		          sum1 +=num;
		          h1[i] = num;
		        }
	        
	        int[] h2 = new int[n2];
	        int sum2 = 0;
	        for(int i=0; i < n2; i++){
		          int num = in.nextInt();
		          sum2 +=num;
		          h2[i] = num;
		        }
	        
	        int[] h3 = new int[n3];
	        int sum3 = 0;
	        for(int i=0; i < n3; i++){
		          int num = in.nextInt();
		          sum3 +=num;
		          h3[i] = num;
		        }
	       
		
		System.out.println(findEqualHeight(h1,sum1, h2,sum2, h3,sum3));
	}
	
	static int findEqualHeight(int[] h1, int sum1, int[] h2, int sum2, int[] h3, int sum3) {
	 
	    int i1 = 0;
	    int i2 = 0;
	    int i3 = 0;

	    while (true) {
	        if (sum1 > sum2 || sum1 > sum3) {
	            sum1 -= h1[i1++];
	        } else if (sum2 > sum1 || sum2 > sum3) {
	            sum2 -= h2[i2++];
	        } else if (sum3 > sum1 || sum3 > sum2) {
	            sum3 -= h3[i3++];
	        } else {
	            break;
	        }
	    }

	    return sum1;
	}

	static int sum(int[] arr) {
	    return IntStream.of(arr).sum();
	}

}
