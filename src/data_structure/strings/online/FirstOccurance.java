package data_structure.strings.online;


/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class FirstOccurance {
    public static void main(String[] args) {
      String  haystack = "sadbutsad", needle = "sade";
      System.out.println(strStr(haystack,needle));
    }


    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
