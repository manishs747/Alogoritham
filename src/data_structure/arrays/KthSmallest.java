package data_structure.arrays;

//http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
//
/*
 *Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10 
 * 
 */
import java.util.Arrays;


/*
 * 
 *  function select(list[1..n], k)
     for i from 1 to k
         minIndex = i
         minValue = list[i]
         for j from i+1 to n
             if list[j] < minValue
                 minIndex = j
                 minValue = list[j]
                 swap list[i] and list[minIndex]
     return list[k]
 */
public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7, 10, 4, 3, 20, 15};
	     int  k = 3 ;
	     System.out.println(kthSmallestSort(arr, k));
	}
	
	public static int kthSmallestSort(int [] arr,int k){
		Arrays.sort(arr);
		return arr[k-1];
	}

}
