package algorithams.recurssion;

public class Factorial {


    public static void main(String[] args) {
        for (int i = 1; i <= 10;i++) {
            System.out.println("Factorial of "+i +" is "+factorial(i));
        }

    }

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
