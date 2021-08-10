package data_structure.arrays.online;

import utils.ArrayUtils;


public class DuplicateZeros {

    public static void main(String[] args) {
        int[] a = {1};
        duplicateZeros2Pass(a);
        ArrayUtils.print(a);
    }
    /*
        https://leetcode.com/problems/duplicate-zeros/
     */
    //brilliant solution
    public static void duplicateZeros2Pass(int[] arr) {
        int i, zeroCount = 0;
        for (i = 0; zeroCount + i < arr.length; ++i){
            if(arr[i] == 0){
                zeroCount ++;
            }
        }
        for (i = i - 1; zeroCount > 0; --i) {
            if (i + zeroCount < arr.length) {
                arr[i + zeroCount] = arr[i];
            }
            if (arr[i] == 0){
                arr[i + --zeroCount] = arr[i];
            }
        }
    }


    public static void duplicateZeros2(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        System.out.println(possibleDups);

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }


    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                moveArrElement(arr, i + 1);
                arr[i + 1] = 0;
                i++;
            }
        }
    }


    public static void moveArrElement(int[] arr, int start) {
        for (int i = arr.length - 1; i > start; i--) {
            arr[i] = arr[i - 1];
        }
    }
}
