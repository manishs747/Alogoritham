package arrays.search;

import java.util.Arrays;
import java.util.Scanner;

import arrays.Utility;

//https://www.hackerrank.com/challenges/icecream-parlor/problem
public class IceCreamParlor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	
		2
		4
		5
		1 4 5 3 2
		4
		4
		2 2 4 3
		
		1 4
		1 2    */
		
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
           
	}

	private static int[] icecreamParlor(int money, int[] menu) {
		// TODO Auto-generated method stub
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		Utility.print(sortedMenu);
		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - sortedMenu[i];
			//System.out.println("Complement:"+complement);
			int location = Arrays.binarySearch(sortedMenu, i+1,sortedMenu.length,complement);
			//System.out.println("location:"+location);
			if(location >= 0 && location <sortedMenu.length &&complement == sortedMenu[location]){
				int indices[] = getIndicesfromValue(menu,sortedMenu[i],complement);
				//System.out.println(indices[0]);
				return indices;
			}
		}
		return null;
	}

	private static int[] getIndicesfromValue(int[] menu, int value1, int value2) {
		//System.out.println("Value1:"+value1+" value2:"+value2);
		int index1 = indexOf(menu,value1,-1);
		int index2 = indexOf(menu,value2,index1);
		int [] indices = {Math.min(index1, index2)+1,Math.max(index1, index2)+1};
		return indices;
	}

	private static int indexOf(int[] menu, int value, int excludeThis) {
	    for (int j = 0; j < menu.length; j++) {
			if(menu[j] ==  value && j != excludeThis){
				return j;
			}
		}
	    return -1;
	}
	
	

}
