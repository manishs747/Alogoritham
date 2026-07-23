package company.google.interval;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**]
 * https://leetcode.com/problems/merge-intervals/?envType=company&envId=google&favoriteSlug=google-six-months
 */
public class MergeIntervals {
    public static void main(String[] args) {
       int [][] intervals =  {{1,3},{2,6},{8,10},{15,18}};
       // Output: [[1,6],[8,10],[15,18]]
        ArrayUtils.print(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> result = new ArrayList<>();
        for (int [] interval : intervals){
            if(result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            } else{
                result.getLast()[1] = Math.max(interval[1],result.getLast()[1] );
            }
        }
        return result.toArray(new int [result.size()][2]);
    }
}
