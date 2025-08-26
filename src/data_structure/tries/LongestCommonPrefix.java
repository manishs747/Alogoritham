package data_structure.tries;


/**
 * https://leetcode.com/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=trie
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

       String [] strs = {"advaith","advik","aditya"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {



        return "";
    }


    public static String longestCommonPrefixiterative(String[] strs) {
        String prefix = strs[0];
        for (String str:strs) {
            int j = 0;
            while ( j < prefix.length() && j < str.length() && prefix.charAt(j) == str.charAt(j))
                j++;
            prefix =  prefix.substring(0,j);

        }
        return prefix;
    }
}
