package algorithams.binarysearch;


/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {{1,1}};
        int target = 2;
        System.out.println(searchMatrix(matrix,target));
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0 , end = matrix.length * matrix[0].length -1;
        while (start <= end){
            int mid  = start + (end-start)/2 ;
            int mr = mid/matrix[0].length , mc = mid% matrix[0].length;
            if(matrix[mr][mc] == target) return true;
            if(matrix[mr][mc] < target){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return false;
    }
}
