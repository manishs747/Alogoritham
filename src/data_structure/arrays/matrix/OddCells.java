package data_structure.arrays.matrix;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/?envType=problem-list-v2&envId=xcko6d8v
 */
public class OddCells {


    public static void main(String[] args) {
        int m = 2, n = 3 ;
        int [][] arr = {{0,1},{1,1}};
        System.out.println(oddCellsOptimized(m,n,arr));
    }




    public static int oddCellsOptimized(int m, int n, int[][] indices) {
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int [] indice : indices){
            int row = indice[0], col = indice[1];
            rowCount[row]++;
            colCount[col]++;
        }
        int count= 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if((rowCount[i]+colCount[j])%2!=0)
                    count++;
            }
        return count;

    }




    /*****************************************************************************************************************/
    public static int oddCells(int m, int n, int[][] indices) {
        int [][] arr = new int[m][n];
        for (int [] indice : indices){
            int row = indice[0], col = indice [1];
            for (int i = 0; i < n ; i++)
                arr[row][i]++;
            for (int i = 0; i < m  ; i++)
                arr[i][col]++;
        }
        int count = 0;
        for (int [] ar:arr) {
            for (int a:ar) {
                count += a%2 == 1 ? 1: 0;
            }
        }
        return count ;
    }
}
