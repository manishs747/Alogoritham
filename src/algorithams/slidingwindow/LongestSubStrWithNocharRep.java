package algorithams.slidingwindow;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestSubStrWithNocharRep {

    public static void main(String[] args) {
       String s = "tmmzuxt";    //3
        System.out.println(lengthOfLongestSubstring(s));
    }

        public static int lengthOfLongestSubstring(String s) {
            int max = 0 , start = 0;
            Map<Character,Integer> charMap = new HashMap<>();
            for (int end = 0; end < s.length(); end++) {
                       char cur  = s.charAt(end);
                       if(charMap.containsKey(cur) && charMap.get(cur) >= start)
                            start = Math.max(charMap.get(cur),start) +1;
                        charMap.put(cur,end);                   
                        max  = Math.max(max, end-start+1);        
            }
            return max;
        }



    public static int lengthOfLongestSubstring2(String s) {
        int max = 0 , start = 0;
        Set<Character> charSet = new HashSet<>();
        for (int end = 0; end < s.length() ; end++) {
            char cur  = s.charAt(end);
            while (charSet.contains(cur))
                charSet.remove(s.charAt(start++));
            charSet.add(cur);
            max  = Math.max(max, end-start+1);
        }
        return max;
    }
}
