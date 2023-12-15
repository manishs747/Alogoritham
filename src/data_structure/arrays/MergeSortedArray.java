package data_structure.arrays;

import utils.ArrayUtils;

public class MergeSortedArray {

    public static void main(String[] args) {
       int [] nums1 = {1,2,3,0,0,0},nums2 = {2,5,6};
       int  m = 3 , n = 3;
       merge(nums1,m,nums2,n);
        ArrayUtils.print(nums1);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = m+n , i = m-1 , j = n-1;
        while ( j >= 0)
            nums1[--counter] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--]:nums2[j--];
    }
}
