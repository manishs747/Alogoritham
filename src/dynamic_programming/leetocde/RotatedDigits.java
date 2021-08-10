package dynamic_programming.leetocde;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public class RotatedDigits {

     

    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("igdfiiffachebfhgdefhf"));//33
       //System.out.println(wonderfulSubstrings("aabb"));
      // System.out.println(checkWonderfull("fiiff"));
    }


    /**
     * https://leetcode.com/problems/rotated-digits/
     */
    public int rotatedDigits(int n) {



        return -1;
    }


    public static long wonderfulSubstrings(String word) {
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
               // System.out.println(s);
              //  System.out.println(map);
                return false;
            }
        }
        return true;
    }
}
