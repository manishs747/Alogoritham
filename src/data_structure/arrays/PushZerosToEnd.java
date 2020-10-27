package data_structure.arrays;

import utils.ArrayUtils;

public class PushZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] myList = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		//ArrayUtils.print(myList);
		//pushZerosToEnd(myList);
		pushZerosToEndCountMethod(myList);
		ArrayUtils.print(myList);
	}
	
	
	public static void  pushZerosToEnd(int arr[]){
		int nz=0;
       
	for (int i = 0; i < arr.length; i++) {
		
		if(arr[i]==0){
			//System.out.println(" i is "+i);
		    nz = getNonZeroIndex(arr,i);
		   // System.out.println("Z is "+nz);
			ArrayUtils.swap(arr, i, nz);
			//{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
			//{1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
		}
		
	}
	
	}
	
	public static int getNonZeroIndex(int arr[],int z){
		
		for (int i = z; i < arr.length; i++) {
			if(arr[i]!=0){
				z=i;
				break;
			}
		}
		
		return z;
		
	}
	
	
	//another approch
	public static void pushZerosToEndCountMethod(int arr[]){
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0){
				arr[count++]=arr[i];
			}
		}
		for (int i = count; i < arr.length; i++) {
				arr[i]=0;
		}
		
		
	}
	
	
	
	
	
	
}
