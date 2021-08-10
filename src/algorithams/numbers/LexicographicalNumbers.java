package algorithams.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));//[1,10,11,12,13,2,3,4,5,6,7,8,9]
    }

    public static List<Integer> lexicalOrder(int n) {
        String[] strList = new String[n];
        for (int i = 1; i <= n; i++) {
            strList[i - 1] = String.valueOf(i);
        }
        Arrays.sort(strList);
        List<Integer> result = new ArrayList<>();
        for (String s : strList) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
