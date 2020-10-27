package algorithams.sorting;

import java.util.Scanner;

public class Sortingtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int size = in.nextInt();
		int [] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(getIndex(arr, num));

	}
	
	public static int getIndex(int [] arr,int num){
		int index = -1;
		int start = 0;
		int end = arr.length;
		while(start < end){
			int mid = (start+end)/2;
			if(arr[mid] == num){
				return mid;
			}
			if(arr[mid] > num){
				end = mid;
			}else{
				start = mid;
			}
			
		}
		return index;
		
	}

}
