package data_structure.strings.online.premium;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsomorphicString {

    public static void main(String[] args) {
       String s = "paper", t = "title";
        System.out.println(isIsomorphic(s,t)  );
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if((map.containsKey(sc) && map.get(sc) != tc) || (map.containsKey(tc)&& map.get(tc) != sc)) {
                return false;
            }
            map.put(sc, tc);
            map.put(tc,sc);
        }
        return true;
    }
}
