package algorithams.sorting.online;

import java.util.Arrays;

public class MaximumBags {

    public static void main(String[] args) {
        int [] capacity = {2,3,4,5}, rocks = {1,2,4,4};
        System.out.println(MaximumBags(capacity,rocks,2));
    }

    public static int MaximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int c = 0; c <capacity.length ; c++)
            capacity[c] = capacity[c] - rocks[c];
        Arrays.sort(capacity);
        int count = 0;
        for (int n:capacity) {
            if(additionalRocks < n) return count;
            count++;
            additionalRocks -= n;
        }
        return count;
    }
}
