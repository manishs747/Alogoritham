package algorithams.binarysearch;


/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSum {

    public static void main(String[] args) {
       int []  numbers = {1,2,3,4};
       int target = 3;

    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0 , end = numbers.length-1;
        while (numbers[start] + numbers[end] != target){
            if(numbers[start] + numbers[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{start,end};
    }
}
