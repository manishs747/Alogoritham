package stack.online;

/*
https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class DecryptString {


    public static void main(String[] args) {
        String s = "25#";
        System.out.println(freqAlphabets(s));
    }


    /***
       https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
     ****/
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            String current = s.substring(i, i+1);
            if ("#".equals(current)) {
                current = s.substring(i-2, i);
                i = i-2;
            }
            sb.append((char) (Integer.parseInt(current) -1+ 'a'));
        }
        return sb.reverse().toString();
    }

}
