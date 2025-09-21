package data_structure.strings.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));

    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0 ,max = 0;
        for (int i=0;i < s.length();i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start){
                start = map.get(c)+1;
            }
            map.put(c,i);
            max = Math.max(max,i-start+1);
        }
      return max;
    }
}
