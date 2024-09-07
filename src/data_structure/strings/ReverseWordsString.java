package data_structure.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsString {

    public static void main(String[] args) {
       String  s = "i am boy";//Output: "boy am i"
        //yob ma i"
        //boy am i
        System.out.println(reverseWords(s));
    }


    public static String reverseWords(String s) {
        s = reverseString(s);
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String str:words) {
            sb.append(reverseString(str)+" ");
        }
        return sb.toString().trim();
    }

    public static String reverseString(String str)
    {
      return new StringBuilder(str).reverse().toString();
    }

    // remove leading spaces
    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


}
