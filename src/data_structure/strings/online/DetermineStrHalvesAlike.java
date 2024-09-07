package data_structure.strings.online;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/?envType=daily-question&envId=2024-01-12
 */
public class DetermineStrHalvesAlike {


    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }

    public static boolean halvesAreAlike(String s) {
        if (s.length() % 2 != 0) return false;
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count1 = 0, count2 = 0;
        for (int i = 0; i < s.length()/2; i++) {
         if(set.contains(s.charAt(i))) count1++;
         if(set.contains(s.charAt(s.length()-i-1))) count2++;
        }
        return count1 == count2;
    }
}
