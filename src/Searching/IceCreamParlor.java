package Searching;

import java.util.Arrays;

import Array.Utility;

//https://www.hackerrank.com/challenges/icecream-parlor/problem
public class IceCreamParlor {


	public static void main(String[] args) {
		int [] arr = {1, 4 ,5 ,3 ,2};
		Utility.print(icecreamParlor(4, arr));   //return 1 4
		int [] arr1 = {2 ,2, 4, 3};
		Utility.print(icecreamParlor(4, arr1)); // 1 2
	}

	static int[] icecreamParlor(int money, int[] menu) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu,i+1,sortedMenu.length, complement);
			if (location >= 0 && location < menu.length &&   sortedMenu[location] == complement) {   
				return getIndicesFromValues(menu, sortedMenu[i], complement);
			}
		}
		return null;
	}
	
	public static int [] getIndicesFromValues(int [] menu,int value1 ,int value2) {
		int index1 = indexOf(menu, value1, -1);
		int index2 = indexOf(menu, value2, index1);
		int[] index = { Math.min(index1,index2)+1 ,Math.max(index1,index2)+1};
		return index;
	}
	
	public static int indexOf(int[] menu,int value,int excludeThis) {
		for (int i = 0;i < menu.length; i++) {
			if (menu[i] == value && i != excludeThis ) {
				return i;
			}
		}
		return -1;
	}
	
	
	static int[] icecreamParlorN2(int m, int[] arr) {
		int [] result = new int [2];
		for (int i = 0; i < arr.length; i++) {
		     int amount = m - arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (amount == arr[j]) {
					result[0] = i+1;
					result[1] = j+1;
					return result;
				}
			}
		}
		return null;
	}

}
