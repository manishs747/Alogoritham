package bitwise;

public class BitUtil {



    public static int getSetBit(int n){
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
