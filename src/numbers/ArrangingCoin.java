package numbers;

public class ArrangingCoin {
	
	public static void main(String[] args) {
		
		
	}
	
	/*
	 * https://leetcode.com/problems/arranging-coins/
	 *   n = 5  o = 2 
	 *      ¤
			¤ ¤
			¤ ¤
        Because the 3rd row is incomplete, we return 2.

        n = 8 o = 3;
	 */
	
	
	public  static int arrangeCoins(int n) {
		int  result  = 0;
		int i = 1;
		while(n-i >= 0) {
			n =n -i++;
			result++;
		}
		return result;
	}
	
	public  static int arrangeCoinsOther(int n) {
		int srt = (int)Math.sqrt(2 * (double)n);
		return (double)srt * (srt + 1) <= 2 * (double)n ? srt : srt - 1;
	}
	


	
	
	
	
	
	 

}
