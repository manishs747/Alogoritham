package company.google;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
      String  s = "abcabcbb";
      System.out.println(lengthOfLongestSubstring(s));
    }


    public  static int lengthOfLongestSubstring(String s) {
       Set<Character> charSet = new HashSet<>();
       int left = 0 ,  right = 0 , max = 0;
       while ( right < s.length()){
          char ch = s.charAt(right++);
          while (charSet.contains(ch)){
              charSet.remove(s.charAt(left++));
          }
           charSet.add(ch);
          max = Math.max(max, charSet.size());
       }
        return max;
    }
}
