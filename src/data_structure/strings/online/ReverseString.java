package data_structure.strings.online;

public class ReverseString {


    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));//bacdfeg
    }


    /**
     * https://leetcode.com/problems/reverse-string-ii/
     */
    public static String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int current = 0;
        while (current < s.length()) {
            int end = current + k > s.length() - 1 ? s.length() - 1 : current + k-1;
            reverseString(sArr, current, end);
            current += 2 * k;
        }
        return new String(sArr);
    }


    /**
     * https://leetcode.com/problems/reverse-string/
     */
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        reverseString(s, start, end);
    }

    private static void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
