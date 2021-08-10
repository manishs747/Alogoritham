package dynamic_programming.leetocde;


/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public static void main(String[] args) {
     /*   String [] arr = {"abc","axc"};
        for (String str:arr) {
            System.out.println(str+" ==> "+isSubsequence(str,"ahbgdc"));
        }*/
        String s = "abcde";
        String [] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s,words));
    }


    //https://leetcode.com/problems/number-of-matching-subsequences/

    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word:words) {
            if(isSubsequence(word,s)){
                count++;
            }
        }
        return count;
    }


    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public static boolean isSubsequence2(String s, String t) {
        int j=0,count=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            while(j<t.length()){
                if(t.charAt(j)==curr){
                    count++;
                    j++;
                    break;
                }
                j++;
            }
        }
       return count==s.length()?true:false;
    }




}
