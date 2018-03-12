package Sorting;

import java.util.Scanner;

import Array.MoveNumberToEnd;
import Array.Utility;


/*
 * 
 * https://www.hackerrank.com/contests/codestar-long-programming-contest/challenges/arrange-the-apple-baskets/problem
 
  
9
2
8
-1
-1
-1
13
-1
15
20
4
5
7
9
25
 
 */
public class MergeSortedArray {
	
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int [] bigArr = new int [m];
		int bigFilled =  0;
		for (int i = 0; i < m; i++) {
			int current =  in.nextInt();
			if(current != -1){
				bigArr[bigFilled++] = current;
			}
		}
		int n = in.nextInt();
		int smallArr [] = new int [n];
		for (int i = 0; i < n; i++) {
			smallArr[i] = in.nextInt();
		}
		
		mergeMNArray(bigArr, bigFilled, smallArr);
		for (int i = 0; i < bigArr.length; i++) {
			System.out.println(bigArr[i]);
		}
		
	}




	private static void testMergeMn() {
		int [] bigArr = { 2,-1,7,-1,-1,10,-1};
		int bigFilled  = MoveNumberToEnd.pushNumberToEnd(bigArr, -1);
		System.out.println(bigFilled);
	//	Utility.print(bigArr);
		int [] smallArr = {5,8,12,14};
		mergeMNArray(bigArr, bigFilled, smallArr);
		Utility.print(bigArr);
	}
	
	
	
	
	//m +n
	public static void mergeMNArray(int [] bigArr ,int bigFilled,int smallArr []){
		int m = bigFilled -1;
		int n = smallArr.length -1;
		int lastIndex = bigFilled + smallArr.length -1;
		while( n >= 0){
			if(bigArr[m] > smallArr[n]){
				bigArr[lastIndex--] = bigArr[m--];
			}else{
				bigArr[lastIndex--] = smallArr[n--];
			}
		}
	}

}
