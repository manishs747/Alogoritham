package data_structure.strings.online;

public class LengthLastWord {


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }



    public static int lengthOfLastWord(String s) {
        int length = 0;
        int wordLength = 0;

        // Trim the input string to remove leading/trailing whitespace
        String trimmedSentence = s.trim();

        // Iterate through the trimmed sentence from right to left
        for (int i = trimmedSentence.length() - 1; i >= 0; i--) {
            char c = trimmedSentence.charAt(i);

            // Check if the character is a whitespace
            if (Character.isWhitespace(c)) {
                // If we already encountered a word, break the loop
                if (wordLength > 0) {
                    break;
                }
            } else {
                // Increment the word length
                wordLength++;

                // If this is the first character of the last word, store its length
                if (length == 0) {
                    length = wordLength;
                }
            }
        }

        return wordLength;
    }


    public static int lengthOfLastWord1(String s) {

        String trimmedSentence = s.trim();

        // Split the trimmed sentence by whitespace
        String[] words = trimmedSentence.split("\\s+");

        // Get the last word from the array of words
        String lastWord = words[words.length - 1];

        // Return the length of the last word
        return lastWord.length();
    }
}
