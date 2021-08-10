package algorithams.binarysearch;


/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {


    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 10, 15, 20, 29, 53, 100};
        for (int n : arr) {
            System.out.println(binarySearchRecIterative(arr, n));
        }
    }


    public static int binarySearchRec(int nums[], int target) {
        return binarySearchRec(nums, target, 0, nums.length - 1);
    }

        public static int binarySearchRec(int arr[], int k, int start, int end) {
            if (start > end) {
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (k < arr[mid]) {
                return binarySearchRec(arr, k, start, mid - 1);
            }
            return binarySearchRec(arr, k, mid + 1, end);
        }


    public static int binarySearchRecIterative(int nums[], int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
