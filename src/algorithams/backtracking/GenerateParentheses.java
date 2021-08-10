package algorithams.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {


    public static void main(String[] args) {
        //["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(2));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max) {
        System.out.println(str + "   open:"+open+" close:"+close);
        if (str.length() == max * 2) {
            list.add(str);
            System.out.println("Found:"+str);
            return;
        }
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
