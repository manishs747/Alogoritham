package dynamic_programming.leetocde;

public class Tribonacci {

    public static void main(String[] args) {
        System.out.println(tribonacci(2));
    }


    public static int tribonacci(int n) {
        if(n==0||n==1)
            return n;
      int a=0;int b = 1;int c=1, sum;
        for (int i = 3; i < n+1; i++) {
            sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
      return c;
    }
}
