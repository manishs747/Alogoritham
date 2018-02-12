package Hackerrank;

import java.util.Map;
import java.util.Scanner;

public class Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int [] arr = {1,3,2,4};
	  checkSortation(arr);
		

	}
	
	
	
	
	 static void checkSortation(int[] arr) {
		 int n = arr.length;
		 String result = checkReverseUtiLity(arr, n);
		 if(result.isEmpty()){
			 System.out.println("no");
		 }else{
			 String[] ressArr = result.split(",");
			 
			 System.out.print("yes " + ressArr[0]+" "+ressArr[1]);
			 
		 }
		 
	    }
	 
	 static String checkReverseUtiLity(int arr[], int n)
	 {
	     try {
			if (n == 1)
			     return "1,1";
  
			 // Find first increasing part
			 int i;
			 for (i=1; i < n && arr[i-1] < arr[i]; i++);
			 if (i == n)
			     return n+","+n;
  
			 // Find reversed part
			 int j = i;
			 while (arr[j] < arr[j-1])
			 {
			     if (i > 1 && arr[j] < arr[i-2])
			         return "";
			     j++;
			 }
  
			 if (j == n)
			     return j+","+n;
  
			
			 int k = j;
  
			 
			 if (arr[k] < arr[i-1])
			    return "";
  
			 while (k > 1 && k < n)
			 {
			     if (arr[k] < arr[k-1])
			         return "";
			     k++;
			 }
			 return k+","+n;
		} catch (Exception e) {
			//System.out.println("error"+ e);
			return "";
		}
	 }
	 
	 boolean checkReverseUtility1(int arr[], int n)
	 {
	     // Copying the array.
		 int[] temp = new int[n];
	     for (int i = 0; i < n; i++)
	         temp[i] = arr[i];
	  
	     // Sort the copied array.
	     sort(temp, temp + n);
	  
	     // Finding the first mismatch.
	     int front;
	     for (front = 0; front < n; front++)
	         if (temp[front] != arr[front])
	             break;
	  
	     // Finding the last mismatch.
	     int back;
	     for (back = n - 1; back >= 0; back--)
	         if (temp[back] != arr[back])
	             break;
	  
	     // If whole array is sorted
	     if (front >= back)
	         return true;
	  
	     // Checking subarray is decreasing or not.
	     do
	     {
	         front++;
	         if (arr[front - 1] < arr[front])
	             return false;
	     } while (front != back);
	  
	     return true;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int findParkingPrice(String entryTime, String leavingTime) {

		  int hour  = getHour(leavingTime, entryTime);
		  if(hour <= 0){
			 return 0; 
		  }
		  int cost = 2;
		  
		  if(hour == 1){
			 return  cost + 3;
		  }
		  
		  int restHour = hour - 1;
		  cost = 5 + 4*restHour;
		
		 return cost;

    }
	
	
	static int getHour( String leavingTime,String entryTime){
		String[] leavingTimeArr = leavingTime.split(":");
		int lh = Integer.parseInt(leavingTimeArr[0]);
		int lm = Integer.parseInt(leavingTimeArr[1]);
	
		
		String[] entryTimeArr = entryTime.split(":");
		int eh = Integer.parseInt(entryTimeArr[0]);
		int em = Integer.parseInt(entryTimeArr[1]);
		
		int hour = lh -eh ;
		if(em < lm){
			hour = hour + 1;
		}
		return hour;
	}
	
	

}
