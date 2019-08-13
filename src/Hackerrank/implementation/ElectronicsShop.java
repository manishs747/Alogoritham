package Hackerrank.implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/electronics-shop/problem

public class ElectronicsShop {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		int kl = in.nextInt();
		int [] keyboards = new int[kl];
		int dl =  in.nextInt();
		int [] drives = new int[dl];
		for (int i = 0; i < kl; i++) {
			keyboards[i] =  in.nextInt();
		}
		for (int i = 0; i < dl; i++) {
			drives[i] =  in.nextInt();
		}
		System.out.println(getMoneySpent(keyboards, drives, total));

	}


	/*
	 * 10 2 3
		3 1
		5 2 8
		output : 9
	 */


	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int k = 0;
		int d = drives.length -1;
		int max = -1;
		int sum = 0;
		while( k < keyboards.length && d >= 0) {
			sum  = keyboards[k] + drives[d];
			if(sum == b) {
				return b; 
			}else if (sum <= b) {
				max = Math.max(max, sum);
			
				k++;
			}else {
				d--;
			}
		}
		return Math.max(max, sum);
	}

}
