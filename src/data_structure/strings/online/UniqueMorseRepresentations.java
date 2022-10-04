package data_structure.strings.online;

import java.util.HashSet;

public class UniqueMorseRepresentations {

    public static void main(String[] args) {

    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        HashSet<String> resultSet = new HashSet<>();
        for (String word:words) {
            StringBuilder sb = new StringBuilder();
            for (char c:word.toCharArray()) {
                sb.append(MORSE[c-'a']);
            }
            resultSet.add(sb.toString());
        }
        return resultSet.size();
    }
}
