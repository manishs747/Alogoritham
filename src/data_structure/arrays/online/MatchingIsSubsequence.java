package data_structure.arrays.online;

import java.util.*;

public class MatchingIsSubsequence {


    public static void main(String[] args) {

        String[] words = {"btovxbku","to","zueoxxxjme","yjkclbkbtl"};
        String s =     "btovxbkumc";
        // System.out.println(numMatchingSubseqLinear(s,words));
        System.out.println(numMatchingSubseq(s, words));
        //System.out.println(bisect_right(Arrays.asList(2,4,5,8,12),2));

    }

    /**
     * https://leetcode.com/problems/number-of-matching-subsequences/
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = map.get(c);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.putIfAbsent(c, list);
        }
        System.out.println(map);
        Map<String, Boolean> dp = new HashMap<>();
        for (String word : words) {
            if (isSubsequenceMemo(word, map, dp)) {
                System.out.println(word);
                count++;
            }
        }
        return count;
    }

    public static boolean isSubsequenceMemo(String s, Map<Character, List<Integer>> memo, Map<String, Boolean> dp) {
        if (s.length() == 0) return true;
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        int prev = -1;
        for (char c : s.toCharArray()) {
            List<Integer> list = memo.get(c);
            if (list == null) {
                dp.put(s, false);
                return false;
            }
            int loc = bisect_right(list, prev);
            System.out.println("PREV:"+prev+" LOC:"+loc);
            if (loc > list.size() - 1) {
                dp.put(s, false);
                return false;
            }
            prev = list.get(loc);
        }
        dp.put(s, true);
        return true;
    }


    public static int bisect_right(List<Integer> A, int x) {
        return bisect_right(A, x, 0, A.size());
    }

    public static int bisect_right(List<Integer> A, int x, int lo, int hi) {

        int N = A.size();
        if (N == 0) {
            return 0;
        }
        if (x < A.get(lo)) {
            return lo;
        }
        if (x > A.get(hi - 1)) {
            return hi;
        }
        for (; ; ) {
            if (lo + 1 == hi) {
                return lo + 1;
            }
            int mi = (hi + lo) / 2;
            if (x < A.get(mi)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }


    public static int numMatchingSubseqLinear(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, s)) {
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
}
