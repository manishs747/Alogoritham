package algorithams.backtracking.online.combinatorics;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        String s = "C";
        //Output: ["a1b2","a1B2","A1b2","A1B2"]
        System.out.println(letterCasePermutation(s));

    }

    public static List<String> letterCasePermutation(String s) {
        List<String>  result = new ArrayList<>();
        letterCasePermutation(s.toCharArray(),0,new StringBuilder(),result);
        return result;
    }

    public static  void letterCasePermutation(char[] charr , int index ,StringBuilder sb , List<String> result) {
         if(sb.length() == charr.length){
             result.add(sb.toString());
             return ;
         }
            char c = charr[index];
            sb.append(c);
            letterCasePermutation(charr,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        if(Character.isLetter(c)){
            sb.append(Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c));
            letterCasePermutation(charr,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void letterCasePermutation(char[] chs, List<String> res, int index) {
        if (index == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (Character.isDigit(chs[index])) {
            letterCasePermutation(chs, res, index + 1);
            return;
        }
        chs[index] = Character.toLowerCase(chs[index]);
        letterCasePermutation(chs, res, index + 1);
        chs[index] = Character.toUpperCase(chs[index]);
        letterCasePermutation(chs, res, index + 1);
    }

    public static List<String> letterCasePermutationIteraive(String s) {
        if (s == null) return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String current = queue.poll();
                    char[] chars = current.toCharArray();

                    // Lowercase permutation
                    chars[i] = Character.toLowerCase(chars[i]);
                    queue.offer(new String(chars));

                    // Uppercase permutation
                    chars[i] = Character.toUpperCase(chars[i]);
                    queue.offer(new String(chars));
                }
            }
        }

        return new ArrayList<>(queue);
    }



}
