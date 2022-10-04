package data_structure.strings.online;


import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/strong-password-checker-ii/
 * It has at least 8 characters.
 * It contains at least one lowercase letter.
 * It contains at least one uppercase letter.
 * It contains at least one digit.
 * It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
 * It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
 */
public class StrongPasswordCheckerII {

    public static void main(String[] args) {
       String password = "IloveLe3tcode!";
        System.out.println(strongPasswordCheckerII(password));
    }


    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        HashSet<Character> specCharSet = new HashSet<>();
        for (char c : "!@#$%^&*()-+".toCharArray()) specCharSet.add(c);
        boolean low = false, upper = false, digit = false, special = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false; //checking same continous char
            upper = Character.isUpperCase(c) ? true : upper;
            low = Character.isLowerCase(c) ? true : low;
            digit = Character.isDigit(c) ? true : digit;
            special = specCharSet.contains(c) ? true : special;
        }
        return low && upper && digit && special;
    }
}
