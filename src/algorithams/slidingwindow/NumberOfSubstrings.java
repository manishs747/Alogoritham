package algorithams.slidingwindow;


/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
 */
public class NumberOfSubstrings {

    public static void main(String[] args) {
       String s = "abcabc";
        //Output: 10

        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0 , right = 0 , total = 0;
        int [] freq = new int[3];
        while (right < len) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;
            while (hasAllChars(freq)) {
                total += len - right;
                // Remove leftmost character and move left pointer
                freq[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return total;
    }

    private static boolean hasAllChars(int[] freq) {
        // Check if we have at least one of each character
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }


}
