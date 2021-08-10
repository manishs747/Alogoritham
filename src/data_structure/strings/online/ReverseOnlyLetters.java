package data_structure.strings.online;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {


    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(s);
        System.out.println(reverseOnlyLetters(s));   //"j-Ih-gfE-dCba"
    }

    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;
        while (start < end) {
            if(!Character.isLetter(ch[start])){
                start++;
                continue;
            }
            if(!Character.isLetter(ch[end])){
                end--;
                continue;
            }
            char tmp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = tmp;
        }
        return new String(ch);
    }
}
