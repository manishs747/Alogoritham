package data_structure.arrays.online;

public class SumEvenNumbersAfterQueries {

    public static void main(String[] args) {

    }


    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        int result [] = new int[nums.length];
        for (int num :nums) evenSum +=  num%2 == 0 ? num : 0;
        for (int [] arr : queries) {

        }
        return null;
    }
}
