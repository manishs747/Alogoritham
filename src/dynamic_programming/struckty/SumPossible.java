package dynamic_programming.struckty;


import java.util.List;

/***
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SumPossible {

    public static void main(String[] args) {
        System.out.println(sumPossible(13, List.of(6, 2, 1)));
    }

    public static boolean sumPossible(int amount, List<Integer> numbers) {
       return sumPossible(amount,numbers,new Boolean [amount+1]);
    }

    public static boolean sumPossible(int amount, List<Integer> numbers,Boolean [] memo) {
          if(amount == 0) return true;
          if(amount < 0)  return false;
          if(memo[amount] != null ) return memo[amount];
          for (int num:numbers) {
               if(sumPossible(amount - num,numbers,memo))
                   return memo[amount] = true;
          }
          return memo[amount] = false;
    }
}
