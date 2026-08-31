package algorithams.slidingwindow;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start= 0 , max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() ; i++) {
            char cur = s.charAt(i);
            if(set.contains(cur)){
                max = Math.max(max,i-start);
                while (set.contains(cur)){
                    set.remove(s.charAt(start++));
                }
            }
                set.add(cur);
        }
        max = Math.max(max,s.length()-start);
        return max;
    }



}
