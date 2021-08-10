package data_structure.strings.online;


/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 */
public class MinSwapsBalanceBracket {

    public static void main(String[] args) {
        System.out.println();
    }


    public int minSwaps(String s) {
        int stack = 0;
        for (char c : s.toCharArray()) {
            if ('[' == c) stack++;
            else if (stack > 0) stack--;
        }
        return (stack + 1) / 2;
    }

    public int minSwaps2(String s) {
        int count = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            if ('[' == c)
                balance++;
            else if (balance == 0)
                count++;
            else
                balance--;
        }
        return (count + 1) / 2;
    }
}
