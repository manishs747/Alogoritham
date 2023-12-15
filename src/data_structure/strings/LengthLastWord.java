package data_structure.strings;


/**
 * https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }



    public static int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length()-1; i >= 0 ; i--)
            if(s.charAt(i) == ' ') return s.length()-i-1;
        return s.length();
    }


}
