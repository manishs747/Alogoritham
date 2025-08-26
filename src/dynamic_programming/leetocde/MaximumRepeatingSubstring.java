package dynamic_programming.leetocde;


/**
 * https://leetcode.com/problems/maximum-repeating-substring/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
 */
public class MaximumRepeatingSubstring {

    public static void main(String[] args) {

        String seq = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        //Output: 2
        //Explanation: "abab" is a substring in "ababc".
        System.out.println(maxRepeating(seq,word));

    }


        public static int maxRepeating(String sequence, String word) {
            int maxRepeat = 0;
            int wordLength = word.length();
            int sequenceLength = sequence.length();

            // We loop through every index in the sequence
            for (int i = 0; i <= sequenceLength - wordLength; i++) {
                int repeatCount = 0;

                // Check how many times the word repeats starting from index i
                while (i + repeatCount * wordLength < sequenceLength &&
                        sequence.startsWith(word, i + repeatCount * wordLength)) {
                    repeatCount++;
                }

                // Update the maximum repeat count
                maxRepeat = Math.max(maxRepeat, repeatCount);
            }

            return maxRepeat;
        }






    /******************************************************************************************************/


    public static int maxRepeating2(String sequence, String word) {
        int max = 0;
        for (int i = 0; i <= sequence.length()-word.length() ; i++) {
            if(sequence.charAt(i) == word.charAt(0)){
                int maxRepeat = maxRepeatFun(sequence, i , word);
               max =  Math.max(maxRepeat,max);
                i += maxRepeat*word.length();
            }
        }
        return max;
    }

    private static int maxRepeatFun(String sequence, int i, String word) {
        int count = 0;
        for (int j = i; j <= sequence.length()-word.length() ; j += word.length()) {
           if( !isSubstringAtIndex(sequence,word,j)) return count;
           count++;
        }
        return count;
    }

    public static boolean isSubstringAtIndex(String mainString, String subString, int index) {
        if (index < 0 || index + subString.length() > mainString.length()) return false;
        for (int i = 0; i < subString.length(); i++) {
            if (mainString.charAt(index + i) != subString.charAt(i)) return false;
        }
        return true;
    }


}
