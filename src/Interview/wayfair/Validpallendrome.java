package Interview.wayfair;

public class Validpallendrome {

    public static void main(String[] args) {
       String s =
                "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()) {
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb);
        return sb.toString().equals(sb.reverse().toString());

    }


}
