package bitwise;


/*
https://www.baeldung.com/java-bitwise-operators

First, the operands are converted to their binary representation
Next, the operator is applied to each binary number and the result is calculated
Finally, the result is converted back to its decimal representation


 */
public class BitWiseDemo {



    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println(a+" & "+b+" : "+(a&b));
        System.out.println(a+" | "+b+" : "+(a|b));

        System.out.println(a+" ^ "+b+" : "+(a^b));
        /*
        Bitwise Complement (~) – operator is unary operator, denoted by ‘~’. It returns the one’s compliment representation of the input value,
        i.e, with all bits inversed, means it makes every 0 to 1, and every 1 to 0.
        Note – Compiler will give 2’s complement of that number, i.e., 2’s compliment of 5 will be -6.

         n = -(n+1)
         Negative Numbers are store in Two Complement form

          Bitwise COMPLEMENT (~)
        Bitwise Not or Complement operator simply means the negation of each bit of the input value.
        It takes only one integer and it's equivalent to the ! operator.
         */
        System.out.println("~"+a+" = "+(~a));

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(~a));
        System.out.println(Integer.toBinaryString(-a));


        System.out.println(" Left shift "+a+" : "+(a << 1));
        System.out.println(" Right shift "+a+" : "+(a >> 1));






    }
}
