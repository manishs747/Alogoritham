package Interview.wayfair;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-divisible-substrings/description/?envType=company&envId=wayfair&favoriteSlug=wayfair-all
 */
public class DivisibleSum {
    public static Map<Character,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('a',1);
        map.put('b',1);
        map.put('c',2);
        map.put('d',2);
        map.put('e',2);
        System.out.println();
        System.out.println(countDivisibleSubstrings("asdf"));
    }

    public static int countDivisibleSubstrings(String word) {
        System.out.println(getAllpermutation(word));



        return -1;
    }


    public static List<String> getAllpermutation (String word){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length() ; i++) {
            for (int j = i; j < word.length(); j++) {
                list.add(word.substring(i,j+1));
            }
        }
        return list;
    }
}
