package Array;

import java.util.Scanner;


/*
 * 
 * 
 *  4
    1 4 3 2
    
    out put
    2 3 4 1

 */

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int arr[] = getInput();
		  
		  printReverse(arr);
		  
		  
		  
		  reverseArray(arr);
		  Utility.print(arr);
	}

	private static void printReverse(int[] arr) {
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]+" ");
		  }
	}

	private static void reverseArray(int[] arr) {
		int s=0;
		 int e = arr.length-1;
		 while(s<e){
			 int tmp = arr[s];
			 arr[s]=arr[e];
			 arr[e]=tmp;
			 s++;
			 e--;
		 }
	}

	private static  int[] getInput() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        return arr;
	}

}
