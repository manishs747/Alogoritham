package data_structure.strings.online;


/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeStringsAlternate {


    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternatelyV3(word1, word2));
    }


    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = 0, w2 = 0;
        while (w1 < word1.length() && w2 < word2.length()) {
            sb.append(word1.charAt(w1++));
            sb.append(word2.charAt(w2++));
        }
        while (w1 < word1.length()) sb.append(word1.charAt(w1++));
        while (w2 < word2.length()) sb.append(word2.charAt(w2++));
        return sb.toString();
    }


    public static String mergeAlternatelyV2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = 0, w2 = 0;
        while (w1 < word1.length() || w2 < word2.length()) {
            if (w1 < word1.length()) sb.append(word1.charAt(w1++));
            if (w2 < word2.length()) sb.append(word2.charAt(w2++));
        }
        return sb.toString();
    }

    public static String mergeAlternatelyV3(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length(); i++) {
            if (i < word1.length()) sb.append(word1.charAt(i));
            if (i < word2.length()) sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}
