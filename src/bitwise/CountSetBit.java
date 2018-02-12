package bitwise;

//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
/*
 
  Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits

Input : n = 13
Output : 3
Binary representation of 11 is 1101 and has 3 set bits
 * 
 */
//count bit which are 1 
public class CountSetBit {
	
	public static void main(String[] args) {
		int n = 13;
		
		
		 System.out.println(countSetBits(n));
	}

	private static int getSetCountIterative(int n) {
		String binary = Integer.toBinaryString(n);
	     int count = 0;
		   for (int i = 0; i < binary.length(); i++) {
			    int val = Character.getNumericValue(binary.charAt(i));
			    if(val == 1){
			    	count++;
			    }
		    }
		   return count;
	}
	
	/* Function to get no of set 
    bits in binary representation 
    of positive integer n */
	//  n * 1 = gives 1 if last bit is 1 else 0;
	static int countSetBits(int n)
	{
		int count = 0;
		while (n > 0)
		{
			count += n & 1;
			n =  n >> 1;
		}
		return count;
	}
	static int countSetBitsRec(int n)
	{
		if(n == 0){
			return 0;
		}
		return (n & 1) + countSetBitsRec(n >> 1);

	}
	
	/*
	 * Implementation of Brian Kernighan’s Algorithm
	 *  1  Initialize count: = 0
   2  If integer n is not zero
      (a) Do bitwise & with (n-1) and assign the value back to n
          n: = n&(n-1)
      (b) Increment count by 1
      (c) go to step 2
   3  Else return count
	 */
	static int countSetBitsBrian(int n)
    {
        int count = 0;
        while (n > 0)
        {
            n &= (n - 1) ;
            count++;
        }
        return count;
    }

}
