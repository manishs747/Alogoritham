package dynamic_programming.leetocde;

import java.util.HashMap;

public class CountVowelStrings {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1) );

    }


    public static int countVowelStrings(int n) {
        int sum = 5;
        int [] memo = {1,1,1,1,1};
        while (n-- > 1){
            int currentSum = 0;
            for (int i = 0; i < memo.length ; i++) {
                currentSum += sum;
                int tmp = memo[i];
                memo[i] = sum;
                sum -= tmp;
            }
            sum = currentSum;
        }
        return sum;
    }
}
