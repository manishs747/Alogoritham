package Array.matrix;

public class DiagonalPrint {

	
	/*
	 * 
	 * https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
	 
	 Given matrix is
    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20

Diagonal printing of matrix is
    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20
	 
	 
	 */
	public static void main(String[] args) {

		int [][] arr =
			      { {10, 20, 30, 40},
					{15, 25, 35, 45},
					{27, 29, 37, 48},
					{32, 33, 39, 50}};
		// TODO Auto-generated method stub
		printDiagonal(arr);

	}

	
	/*
	 * r = r-1
	 * c = c+1
	 */
	
	public static void printDiagonal(int [][] arr) {
		int Row = arr.length;
		int Col = arr[0].length;
		int r = 0 ,c =0;
		//handle row
		while(r < Row) {
			int r1 = r;
			int c1 = c;
			while(r1 >=0 && c1 < Col) {
				System.out.print(arr[r1][c1]+" ");
				r1--;
				c1++;
			}
			System.out.println();
			r++;
		}
		r = Row-1;c=1;
		while(c < Col) {
			int r1 = r;
			int c1 = c;
			while(r1 >=0 && c1 < Col) {
				System.out.print(arr[r1][c1]+" ");
				r1--;
				c1++;
			}
			System.out.println();
			c++;
		}

	}

}
