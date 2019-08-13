package Hackerrank;

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/the-salesman/problem
/*
 * 
 * 
 * 
 * 
 * 
 */

public class TheSalesMan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//less than half first   and if pages odd last page will have 2 page
	static int pageCount(int n, int p) {
		boolean front = true;
		if( p > n/2) {
			front = false;
		}
		int pageCount = 0;
		if(front) {
			pageCount = p/2;
		}else {
			if (n%2== 0) {
				n = n -p+1;
			}else {
				n = n -p;
			}
			pageCount =n/2;
		}
		return pageCount;
	}
	 

}
