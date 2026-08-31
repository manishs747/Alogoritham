package algorithams.prefixsum;


import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=problem-list-v2&envId=prefix-sum
 */
public class LargestAltitude {

    public static void main(String[] args) {

        int [] gain = {-5,1,5,0,-7};
        System.out.println();

    }

    public int largestAltitude(int[] gain) {
        int maxHeaght = 0 , height = 0;
        for (int g:gain ){
            height += g;
            maxHeaght = Math.max(maxHeaght,height);
        }
        return maxHeaght;
    }
}
