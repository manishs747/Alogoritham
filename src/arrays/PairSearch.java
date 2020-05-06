package arrays;

import java.util.Arrays;


/*
 * https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 * 
 * 
 * https://www.hackerrank.com/challenges/pairs/problem
 * 
 */
public class PairSearch {
	
	
	public static void main(String[] args) {	
		int x = 16;
		int arr[] = {1, 4, 45, 6, 10, -8};
		System.out.println(hasArrayTwoCandidates(arr, x));
	}
	
	
	public static boolean hasArrayTwoCandidates(int [] arr ,int x){
		Arrays.sort(arr);
		Utility.print(arr);
		int l = 0;
		int r = arr.length -1;
		while(l<r){
			System.out.println("Checking"+arr[l]+":"+arr[r]);
			if(arr[l] + arr[r] == x){
				System.out.println("Found:"+arr[l]+":"+arr[r]);
				return true;
			}
			if(arr[l] + arr[r] < x){
				l++;
			}else{
				r--;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	public static void printValueWithSum(int [] arr ,int x){
		Arrays.sort(arr);  //nlogn
		Utility.print(arr);
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int value = x - current;
			int found = -1;
			System.out.println("Searching current index :"+i+" value"+current+" for value"+value);
			if(value < current){//left
				System.out.println("left");
				found = BinarySearch.binarySearch(arr, 0, i-1, value)	;
			}else{//right
				System.out.println("right "+(i+1)+" : "+ (arr.length - 1));
				found = BinarySearch.binarySearch(arr, i+1, arr.length-1, value);
				System.out.println("Found:"+found);
			}
		   if(found != -1){
			  System.out.println("Numbers are "+ current + " and "+ arr[found]); 
		   }
		}
		
	}
	

	
	
	

}
