package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
   /*     Input: strs = ["flower","flow","flight"]
        Output: "fl"*/
        String [] strs = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
          if(strs == null || strs.length == 0) return "";
           String prefix = strs[0];
        for (String str:strs) {
            int j = 0;
            while (j < str.length()&& j < prefix.length() && prefix.charAt(j) == str.charAt(j))
                j++;
            prefix = prefix.substring(0,j);
            if(prefix.length() == 0) return "";
        }
        return prefix;
    }

}
