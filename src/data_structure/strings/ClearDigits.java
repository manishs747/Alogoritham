package data_structure.strings;


/***
 * https://leetcode.com/problems/clear-digits/description/?envType=daily-question&envId=2025-02-10
 */
public class ClearDigits {


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }


    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()) {
            if(Character.isDigit(c))
                sb.deleteCharAt(sb.length()-1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
