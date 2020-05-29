package String.online;

import java.util.HashSet;
import java.util.Set;

public class maxvowel {


    public static void main(String[] args) {
        String word = "aeiou";
        System.out.println( maxVowels(word,2));
    }



    /*
            Given a string s and an integer k.
            Return the maximum number of vowel letters in any substring of s with length k.
            Vowel letters in English are (a, e, i, o, u).

                Input: s = "abciiidef", k = 3
                Output: 3
                Explanation: The substring "iii" contains 3 vowel letters.
                Example 2:

                Input: s = "aeiou", k = 2
                Output: 2
                Explanation: Any substring of length 2 contains 2 vowels.
                Example 3:

                Input: s = "leetcode", k = 3
                Output: 2
                Explanation: "lee", "eet" and "ode" contain 2 vowels.
     */

    public static int maxVowels(String s, int k) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        char[] charr = s.toCharArray();
        int lc = 0;
        for (int i = 0; i < k; i++){
            if (vowelSet.contains(charr[i])) { lc++; }
        }
        int max = lc;

        for (int i = k; i < charr.length; i++) {
            char prevChar = charr[i-k];
            char next = charr[i];
            if(vowelSet.contains(prevChar)){
                lc--;
            }
            if(vowelSet.contains(next)){
                lc++;
            }

            max = Math.max(max, lc);
        }
        return max;
    }
}
