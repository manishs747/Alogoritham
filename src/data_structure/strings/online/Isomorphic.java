package data_structure.strings.online;

import java.util.*;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Isomorphic {

    public static void main(String[] args) {
       String [] arr = { "abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(findAndReplacePattern(arr,"abb"));
        //System.out.println(isIsomorphic("badc","baba"));
    }


    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word:words) {
            if(isIsomorphic(word,pattern)){
                list.add(word);
            }
        }
        return list;
    }


    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Set<Character> tset = new HashSet<>();
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length() ; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.containsKey(sc) ){
                if(map.get(sc) != tc){
                    return false;
                }
            }else {
                if(tset.contains(tc)){
                    return false;
                }
                tset.add(tc);
                map.put(sc,tc);
            }
        }
        return true;
    }
}
