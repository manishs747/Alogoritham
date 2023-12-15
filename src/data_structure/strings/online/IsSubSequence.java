package data_structure.strings.online;


/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsSubSequence {

    public static void main(String[] args) {
       String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()){
            if(s.charAt(si) == t.charAt(ti++))
                si++;
        }
        return si == s.length();
    }
}
