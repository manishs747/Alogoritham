package data_structure.strings.online;


/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/?envType=daily-question&envId=2025-02-05
 */
public class AreAlmostEqual {


    public static void main(String[] args) {
      String  s1 = "aa", s2 = "ac";
        System.out.println(areAlmostEqual(s1,s2));
    }


    public  static boolean areAlmostEqual(String s1, String s2) {
        char cs1 = '0', cs2  = '0';
        int numberOfMisMatch = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i) ){
                numberOfMisMatch++;
                if(cs1 == '0'){
                    cs1 = s1.charAt(i);
                    cs2 = s2.charAt(i);
                }else if ( s1.charAt(i) != cs2 || s2.charAt(i)  != cs1){
                    return false;
                }
            }
        }
        return numberOfMisMatch == 0 || numberOfMisMatch ==2;
    }
}
