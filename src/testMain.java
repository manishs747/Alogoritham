import java.math.BigInteger;

public class testMain {


    public static void main(String[] args) {
        System.out.println(addStrings("111","1235"));


    }

    public static String addStrings(String num1, String num2) {
        return new BigInteger(num2).add(new BigInteger(num1)).toString();
    }

}
