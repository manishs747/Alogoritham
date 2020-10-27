package algorithams.backtracking;

import java.util.HashSet;
import java.util.Set;

public class UniquePossible {

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }


    public static int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        permute(tiles.toCharArray(),0,tiles.length()-1,set);
        System.out.println(set);
        return 0;
    }


    static void permute(char[] str, int l, int r,Set<String> set) {
        if (l == r) {
            set.add(new String(str));
           // System.out.println(str);
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(str, l, i);
            permute(str, l + 1, r,set);
            swap(str, l, i);
        }
    }


    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}

