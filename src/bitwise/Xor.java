package bitwise;

public class Xor {

    /*
    https://www.baeldung.com/java-xor-operator


The XOR logical operation, or exclusive or, takes two boolean operands
and returns true if and only if the operands are different.

     */

    public static void main(String[] args) {
         boolean isDiseal = false;
         boolean isManual = true;

        boolean dieselXorManual = (isDiseal && !isManual) || (!isDiseal && isManual);  //using java
         dieselXorManual = isDiseal ^ isDiseal;  //using bit wise

         int result = 3 ^ 0;
        System.out.print(result);
    }



    /*
    https://www.hackerrank.com/challenges/lonely-integer/problem
    That one is unique in the array
    For example,a =[1,2,3,4,3,2,1] , the unique element is .4
     */
    static int lonelyinteger(int[] a) {
      int result = 0;
        for (int value :a) {
            result ^= value;
        }
       return result;
    }


    static long sumXor(long n) {
        int unset_bits=0;
        while (n > 0)
        {
            if ((n & 1) == 0)
                unset_bits++;
            n=n>>1;
        }

        // Return 2 ^ unset_bits
        return 1 << unset_bits;
    }


}
