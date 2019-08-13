package Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class MissingNumber {
	
	
	public static void main(String[] args) {
		//int [] arr = {203 ,204, 205, 206, 207, 208, 203, 204, 205, 206};
		//int [] brr = {203 ,204, 204 ,205, 206 ,207, 205 ,208, 203, 206, 205 ,206, 204};
		
		int [] arr = {11 ,4 ,11, 7 ,13 ,4 ,12, 11 ,10 ,14};
		int [] brr = {11, 4 ,11 ,7, 3 ,7, 10, 13, 4, 8 ,12, 11 ,10 ,14, 12};
		Array.Utility.print(missingNumbers(arr, brr));
		
	}
	
	
	static int[] missingNumbers(int[] arr, int[] brr) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int key : brr) {
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
		}
		for (int key : arr) {
			if(map.get(key) == 1) {
				map.remove(key);
			}else {
				map.put(key, map.get(key)-1);
			}
		}
		int[] result = new int [map.size()] ;
		 int j = 0; 
	        for (int x : map.keySet()) 
	        	result[j++] = x;
		Arrays.sort(result);
		return result;
	}

}
