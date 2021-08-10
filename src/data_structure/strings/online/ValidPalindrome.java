package data_structure.strings.online;


public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "cbbcc";
        System.out.println(validPalindromeOneAllowed(s));

    }


    /**
     * https://leetcode.com/problems/valid-palindrome-ii/
     * only char
     */

    public static boolean validPalindromeOneAllowed(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1))
                    return true;
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    /************************************Pallendrom check with alpha numeric****************************************/

    /**
     * https://leetcode.com/problems/valid-palindrome/
     */


    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!isAlphanumericChar(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlphanumericChar(s.charAt(end))) {
                end--;
                continue;
            }
            if (toLower(s.charAt(start++)) != toLower(s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }


    private boolean isAlphanumericChar(char c) {
        return '0' <= c && c <= '9' || 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
    }

    private char toLower(char c) {
        return ('A' <= c && c <= 'Z') ? (char) (c + ' ') : c;
    }

    public static boolean isPalindromeSlow(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        return s.equals(new StringBuilder(s).reverse().toString());
    }


}
