package data_structure.arrays.online;

import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray2 {

    public static void main(String[] args) {

    }

    private int[] arr;
    private int[] original;
    Random rand = new Random();

    public ShuffleArray2(int[] nums) {
        original = nums;
        arr = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        arr = original.clone();
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            swapAt(i, randRange(i, arr.length));
        }
        return arr;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
