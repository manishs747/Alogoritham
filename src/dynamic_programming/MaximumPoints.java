package dynamic_programming;

public class MaximumPoints {

    public static void main(String[] args) {
   int [] arr = {2,2,2};
        System.out.println(maxScore(arr,2));
    }

    /**
     * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
     *
     */


    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
             sum += cardPoints[i];
        }
        int maxPoint = sum;
        for (int i = 0; i < k; i++) {
            int add = cardPoints[i];  // 1
            int sub = cardPoints[cardPoints.length - k + i]; //5
            sum  = sum + add - sub ;
            maxPoint = Math.max(sum, maxPoint);
        }
        return maxPoint;
    }
}
