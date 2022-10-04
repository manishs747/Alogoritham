package data_structure.strings.online;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidateAnagram {

    public static void main(String[] args) {
      String  s = "anagram", t = "nagaram";
      System.out.println(isAnagram(s,t));
    }


    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int [] memo = new int [26];
        for (char c:s.toCharArray()) memo[c-'a']++;
        for (char c:t.toCharArray()) memo[c-'a']--;
        for (int val:memo) if (val != 0) return false;
        return true;
    }
}
