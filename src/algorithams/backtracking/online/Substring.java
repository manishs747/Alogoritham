package algorithams.backtracking.online;

public class Substring {

    /**
     * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
     * @param args
     */
    public static void main(String[] args) {
      String haystack = "mississippi", needle = "issipi";
       // String haystack = "aaa", needle = "aa";
        System.out.println(strStr(haystack,needle));
    }


    public static int strStrUsingInBuild(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n-m ; i++) {
            int j;
            for ( j = 0; j < m ; j++) {
                if( haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if(j == m) return i;
        }
        return -1;
    }
}
