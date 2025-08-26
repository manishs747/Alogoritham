package algorithams.backtracking.online;


import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
       String s = "aab";
       // Output: [["a","a","b"],["aa","b"]]

       // System.out.println(isPallendrome("paap",0,3));

        System.out.println(partitionDP(s));
    }
    public static List<List<String>> partitionBackTrack(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionRefactor(s,0,new ArrayList<>(),result);
        return result;
    }


    public static void partitionRefactor(String s , int start  , List<String> currentWord , List<List<String>> result ) {
       if(start >= s.length()){
           result.add(new ArrayList<>(currentWord));
           return;
       }
       for (int i = start+1; i <= s.length()  ; i++) {
            String curWord = s.substring(start,i);
            if(isPallendrome(curWord, 0,curWord.length()-1)){
                currentWord.add(curWord);
                partitionRefactor(s,i,currentWord,result);
                currentWord.remove(currentWord.size()-1);
            }
       }
    }



    /***************************************************************DYNAMIC PRGRAMMING **********************************/

    public static List<List<String>> partitionDP(String s){
        return partitionDP(s,new HashMap<>());
    }

    public static List<List<String>> partitionDP(String s , Map<String, List<List<String>>> memo) {
        if(s.isEmpty()) return Arrays.asList(new ArrayList<>());
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= s.length()  ; i++) {
            String curWord = s.substring(0, i);
            if(isPallendrome(curWord, 0,curWord.length()-1)){
                List<List<String>> childList = partitionDP(s.substring(curWord.length()),memo);
                for (List<String> child:childList) {
                    List<String> currentList = new ArrayList<>();
                    currentList.add(curWord);
                    currentList.addAll(child);
                    result.add(currentList);
                }
            }
        }
        memo.put(s,result);
       return result;
    }









    public static  boolean isPallendrome(String str, int start ,int end){
        while (start <= end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

}
