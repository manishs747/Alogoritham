package data_structure.strings.online;


/*
https://www.hackerrank.com/challenges/making-anagrams/problem
https://www.youtube.com/watch?v=3MwRGPPB4tw&list=PLOuZYwbmgZWXvkghUyMLdI90IwxbNCiWK&index=8

 */
public class MakeAnagram {

    public static void main(String[] args) {
        String s1 = "cde";
        String s2 = "abc";

        System.out.println(makingAnagrams(s1,s2));
    }

    static int makingAnagrams(String s1, String s2) {
      int [] charCount1 = getCharCount(s1);
      int [] charCount2 = getCharCount(s2);
      return getDelta(charCount1,charCount2);
    }

    private static int getDelta(int[] charCount1, int[] charCount2) {
        int delta = 0;
        for (int i = 0;i < charCount1.length;i++){
            delta +=   Math.abs(charCount1[i]-charCount2[i]);
        }
        return delta;
    }

    private static int[] getCharCount(String s) {
        int [] charCount = new int[26];
        for (char c:s.toCharArray()) {
            int offset  = 'a';
            int code = c-offset;
            charCount[code]++;
        }
        return charCount;
    }
}
