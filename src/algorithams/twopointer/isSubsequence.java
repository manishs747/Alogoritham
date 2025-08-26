package algorithams.twopointer;


/**
 * https://leetcode.com/problems/is-subsequence/?envType=problem-list-v2&envId=dynamic-programming
 */
public class isSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
       int sp = 0,tp = 0;
       while (sp < s.length() && tp < t.length())
           if(s.charAt(sp) == t.charAt(tp++))
               sp++;
       return sp == s.length();
    }
}
