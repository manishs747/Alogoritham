package algorithams.recurssion.power;

public class PowerOftwo {


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

    //https://leetcode.com/problems/power-of-two/

    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
              return true;
          }
          if(n%2 != 0){
              return false;
          }
        return isPowerOfTwo(n/2);
    }

    public static boolean isPowerOfTwoBitWise(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }



}
