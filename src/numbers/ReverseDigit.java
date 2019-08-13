package numbers;
/*
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseDigit {

	public static void main(String[] args) {
	/*	System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE - 1);
		System.out.println(Integer.MAX_VALUE + 1);*/
		
		
		
		
	System.out.println(reverse(1534236469));

	}
	
	/*
	 * 
	 * 
	 * Input: 123
       Output: 321


	 * Input: -123
       Output: -321
	 *
	 *Input: 120
      Output: 21
	 */
	 public static int reverse(int x) {
		 boolean isNegative =  x < 0 ? true : false;
		 x = Math.abs(x);
		 int result = 0;
		 while(x != 0) {
			int reminder = x%10;
			  if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && reminder > 7)) return 0;
	          if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && reminder < -8)) return 0;
			result = result*10 + reminder;
			x = x/10;
		 }
		 result = result < 0 ? 0 : result ;
		 if(isNegative) {
			 result = result * -1;
		 }
		 return result;    
	 }

}
