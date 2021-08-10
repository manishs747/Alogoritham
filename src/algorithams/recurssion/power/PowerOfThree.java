package algorithams.recurssion.power;

public class PowerOfThree {

    public static void main(String[] args) {

    }

    public boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n%3 != 0 || n < 1){
            return false;
        }
        return isPowerOfThree(n/3);
    }


    public boolean isPowerOfThreeBitwise(int n) {
        return n>0 && 1162261467%n == 0;
    }
}
