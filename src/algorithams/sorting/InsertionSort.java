package algorithams.sorting;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/insertionsort1

import data_structure.arrays.Utility;

/*
 * 
5
3 2 5 4 1


2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8

 * 
 */



public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	         for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	         }
	        // insertIntoSorted(ar,0);
	       //  Utility.printArray(ar);
	         insertsortTest(ar);

	}
	
	
	
	public static void insertsortTest(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int j = i-1;
			int current = arr[i];
			while(j>=0 && arr[j] >  current){
				arr[j+1] = arr[j--];
			}
			arr[j+1] = current;
			Utility.print(arr);
		}
		
		
	}
	
	
	public static void insertsort(int[] array) {
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
			Utility.printArray(array);
		}
	}
	
	private static void insertIntoSorted(int[] ar) {
		int key = ar[ ar.length - 1];
		int i = ar.length - 2;
		while(i >= 0 && ar[i] > key){
			ar[i+1] = ar[i];
			i--;
			Utility.printArray(ar);
		}
		ar[i+1] = key;
		Utility.printArray(ar);
	}

	private static void insertIntoSorted(int[] ar,int k) {
		int key = ar[ ar.length - 1];
		int i;
		for ( i = ar.length - 2; i >= 0; i--) {
			if(ar[i] > key){
				ar[i+1] = ar[i];
				Utility.printArray(ar);
			}else{
				break;
			}
		}
		ar[i+1] = key;
		Utility.printArray(ar);
		
	}

}
