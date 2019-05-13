package utils;

import java.util.Random;

public class ArrayUtils
{
	public static int[] arr;
	
	public static void print(int[] ar) {
        for(int n: ar){
           System.out.print(n+" ");
        }
     }
	
	public static void prints(String[] ar) {
        for(String n: ar){
           System.out.print(n+" ");
        }
     }
	
	 public static void swap(int[] a, int i, int j) {
	        // TODO Auto-generated method stub
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	        //System.out.println("swaping"+a[i]+" , "+a[j]);
	    }
	 
	 public static void generateRandomArray(int len){
		 arr = new int[len];
		 for(int i = 0; i < arr.length; i++) {
		     arr[i] = random();
		 }
	 }

	 public static void main(String[] args) {
		 generateRandomArray(5);
		 print(arr);
	}
	 public static int random(){
		 //note a single Random object is reused here
		   return new Random().nextInt(100);
	 }
	 
	 
}
