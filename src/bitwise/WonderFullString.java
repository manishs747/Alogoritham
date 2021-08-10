package bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-wonderful-substrings/
 */
public class WonderFullString {


    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("igdfiiffachebfhgdefhf"));//33
        //System.out.println(wonderfulSubstrings("aabb"));
        // System.out.println(checkWonderfull("fiiff"));
    }

    public static long wonderfulSubstrings(String word) {


        return 1;
    }


    public static long wonderfulSubstringsNormal(String word) {
        Map<String,Boolean> map = new HashMap<>();
        int count = 0;
        System.out.println(word.length());
        int wordCount = 0;
        for (int i = 0; i < word.length(); i++ ){
            for (int j = i+1; j <= word.length(); j++){
                wordCount++;
                String s = word.substring(i, j);
                map.put(s,checkWonderfull(s,map));
                if(map.get(s)){
                    count++;
                }
            }
        }
        System.out.println("WordCound:"+wordCount);
        return count;
    }

    public static boolean checkWonderfull(String s,Map<String,Boolean> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:map.keySet()) {
            // System.out.println(c+":"+map.get(c)%2);
            if(map.get(c)%2 != 0){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
