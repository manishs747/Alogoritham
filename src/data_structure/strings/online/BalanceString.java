package data_structure.strings.online;


/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class BalanceString {


    public static void main(String[] args) {
       String s = "RLLLLRRRLR";
        System.out.println(balancedStringSplit(s));
    }


    public static int balancedStringSplit(String s) {
        int l = 0, r = 0,count= 0;
        for (char c: s.toCharArray() ) {
            if (c == 'L'){
                l++;
            }else{
                r++;
            }
            if(l == r){
                count++;
                l = r = 0;
            }
        }
        return count;
    }


}




