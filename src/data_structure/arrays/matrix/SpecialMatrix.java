package data_structure.arrays.matrix;

public class SpecialMatrix {


    public static void main(String[] args) {
        int arr[][] = {{0, 0, 5}, {7, 0, 0}, {0, 6, 0}, {0, 0, 0}};
        print(arr);
        transformSpecialMatrix(arr);
    }

    public static void transformSpecialMatrix(int arr[][]) {
        if (null == arr || arr.length == 0) {
            System.out.println(-1);
            return;
        }
        int zeroCount = getNumberOfZero(arr);
        int nonZeroCount = arr.length * arr[0].length - zeroCount;
        if (zeroCount < nonZeroCount) {
            System.out.println(-1);
            return;
        }
        boolean transformed = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int current = arr[i][j];
                if (current == 0) {
                    arr[i][j] = getTransformedValue(arr,i,j);
                    zeroCount--;
                    nonZeroCount++;
                    if (zeroCount < nonZeroCount) {
                        transformed = true;
                        break;
                    }
                }
            }
            if (transformed) {
                break;
            }
        }
        print(arr);
    }

    public  static int getTransformedValue(int arr[][],int row,int col){
        int rowSum = 0;
        for(int c = 0;c < arr[0].length ;c++){
            rowSum = rowSum + arr[row][c];
        }
        int colSum = 0;
        for(int r = 0;r < arr.length ;r++){
            colSum = colSum + arr[r][col];
        }
        if(rowSum <= colSum){
          return   2 - (rowSum%2);
        }
        return   3 - (rowSum%3);
    }

    public static int getNumberOfZero(int arr[][]) {
      int zeroCount = 0;
        for (int[] row : arr) {
            for (int elem : row) {
              if(elem == 0){
                  zeroCount++;
              }
            }
        }
        return zeroCount;
    }


    public static void print(int[][] puzzle) {
        for (int[] row : puzzle) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
        System.out.println();
    }

}
