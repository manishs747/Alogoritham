package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */
public class PartitionDisjoint {


    public static void main(String[] args) {


        int[] arr = {12, 75, 26, 38, 56, 59, 83, 55, 49, 52, 27, 48, 77, 21, 27, 79, 54, 15, 59, 22, 34, 35, 81, 67, 2, 41, 40, 0, 73, 61, 75, 8, 86, 42, 49, 83, 43, 16, 2, 54, 26, 35, 15, 63, 31, 24, 51, 86, 6, 35, 42, 37, 83, 51, 34, 21, 71, 57, 61, 76, 50, 1, 43, 32, 19, 13, 67, 87, 3, 33, 38, 34, 34, 84, 38, 76, 52, 7, 27, 49, 2, 78, 56, 28, 70, 6, 64, 87, 100, 97, 99, 97, 97, 100, 100, 100, 97, 89, 98, 100};
        int[] arr1 = {5, 0, 3, 8, 6};
        System.out.println(arr.length);
        System.out.println(partitionDisjoint(arr1));
    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] minArr = new int[nums.length];
        minArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i > 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                if (max <= minArr[i]) {
                    return i;
                }
                max = nums[i];
            }
        }
        return nums.length - 1;
    }

    public static int partitionDisjoint1(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }
}
